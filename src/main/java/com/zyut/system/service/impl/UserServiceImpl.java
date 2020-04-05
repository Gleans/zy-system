package com.zyut.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyut.system.dao.UserMapper;
import com.zyut.system.exception.CustomException;
import com.zyut.system.model.dto.User;
import com.zyut.system.model.dto.UserRole;
import com.zyut.system.model.error.ErrorCodeEnum;
import com.zyut.system.model.vo.UserInfoVO;
import com.zyut.system.service.UserRoleService;
import com.zyut.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User getUserByUserName(String name) {
        LambdaQueryWrapper<User> lqw = Wrappers.<User>lambdaQuery()
                .eq(User::getUsername, name);
        lqw.last("limit 1");
        return baseMapper.selectOne(lqw);
    }

    @Override
    public IPage<UserInfoVO> getList(UserInfoVO user) {
        QueryWrapper<UserInfoVO> ew = new QueryWrapper<>();
        ew.orderByDesc("uu.user_id");
        ew.groupBy("uu.user_id");

        // 分角色
        if (ObjectUtil.isNotNull(user.getRoleId())) {
            ew.eq("ur.role_id", user.getRoleId());
        }

        IPage<UserInfoVO> userInfoVOIPage = baseMapper.query(new Page<>(user.getPage(), user.getLimit()), ew);
        if (ObjectUtil.isNotEmpty(userInfoVOIPage.getRecords())) {
            userInfoVOIPage.getRecords().forEach(userInfoVO -> {
                if (StringUtils.isNotBlank(userInfoVO.getRoleListStr())) {
                    String[] roleAry = StringUtils.split(userInfoVO.getRoleListStr(), ",");
                    userInfoVO.setRoleList(Stream.of(roleAry)
                            .map(Integer::valueOf)
                            .collect(Collectors.toList()));
                }
            });
        }
        log.info("用户列表返回:{}", JSON.toJSONString(userInfoVOIPage.getRecords(), SerializerFeature.WriteMapNullValue));
        return userInfoVOIPage;
    }

    @Override
    public boolean addUser(UserInfoVO user) {
        log.info("转换前userIn:{}", JSON.toJSONString(user, SerializerFeature.WriteMapNullValue));

        User userIn = BeanUtil.toBean(user, User.class);
        log.info("转换后userIn:{}", JSON.toJSONString(userIn, SerializerFeature.WriteMapNullValue));

        User tempUser = getUserByUserName(user.getUsername());
        if (ObjectUtil.isNotNull(tempUser)) {
            throw new CustomException(ErrorCodeEnum.USERNAME_UNQ);
        }
        // 新增用户
        boolean addUser = this.save(userIn);

        // 新增权限
        boolean addAuth = addAuth(user, userIn);

        return addUser && addAuth;
    }

    @Override
    public boolean updateUser(UserInfoVO user) {
        log.info("转换前userIn:{}", JSON.toJSONString(user, SerializerFeature.WriteMapNullValue));

        User userIn = BeanUtil.toBean(user, User.class);
        log.info("转换后userIn:{}", JSON.toJSONString(userIn, SerializerFeature.WriteMapNullValue));

        LambdaQueryWrapper<User> lqw = Wrappers.<User>lambdaQuery()
                .ne(User::getUserId, userIn.getUserId())
                .eq(User::getUsername, userIn.getUsername());

        User tempUser = baseMapper.selectOne(lqw);
        if (ObjectUtil.isNotNull(tempUser)) {
            throw new CustomException(ErrorCodeEnum.USERNAME_UNQ);
        }

        // 修改用户
        boolean updateUser = this.updateById(userIn);

        LambdaQueryWrapper<UserRole> lqw2 = Wrappers.<UserRole>lambdaQuery()
                .ne(UserRole::getUserId, userIn.getUserId());

        // 删除权限
        boolean removeRole = userRoleService.remove(lqw2);

        // 新增权限
        boolean addAuth = addAuth(user, userIn);

        return updateUser && removeRole && addAuth;
    }

    private boolean addAuth(UserInfoVO user, User userIn) {
        boolean addAuth = true;
        if (ObjectUtil.isNotEmpty(user.getRoleList())) {
            List<UserRole> userRoleList = new ArrayList<>();
            for (Integer roleId : user.getRoleList()) {
                userRoleList.add(new UserRole(roleId, userIn.getUserId()));
            }
            addAuth = userRoleService.saveBatch(userRoleList);
        }
        return addAuth;
    }
}
