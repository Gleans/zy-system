package com.zyut.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyut.system.dao.UserMapper;
import com.zyut.system.model.dto.User;
import com.zyut.system.model.dto.UserRole;
import com.zyut.system.model.vo.UserInfoVO;
import com.zyut.system.service.UserRoleService;
import com.zyut.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public IPage<User> getList(UserInfoVO user) {
        QueryWrapper<User> ew = new QueryWrapper<>();
        return baseMapper.selectPage(new Page<>(user.getPage(), user.getLimit()), ew);
    }

    @Override
    public boolean addUser(UserInfoVO user) {

        User userIn = BeanUtil.toBean(user, User.class);
        // 新增用户
        boolean addUser = this.save(userIn);
        // 新增权限
        boolean addAuth = true;
        if (ObjectUtil.isNotEmpty(user.getRoleList())) {
            List<UserRole> userRoleList = new ArrayList<>();
            for (Integer roleId : user.getRoleList()) {
                userRoleList.add(new UserRole(roleId, user.getUserId()));
            }
            addAuth = userRoleService.saveBatch(userRoleList);
        }

        return addUser && addAuth;
    }
}
