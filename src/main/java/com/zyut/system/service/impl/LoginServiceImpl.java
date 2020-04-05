package com.zyut.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zyut.system.dao.RoleMapper;
import com.zyut.system.exception.CustomException;
import com.zyut.system.model.dto.Role;
import com.zyut.system.model.dto.User;
import com.zyut.system.model.error.ErrorCodeEnum;
import com.zyut.system.model.vo.UserInfoVO;
import com.zyut.system.service.LoginService;
import com.zyut.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserInfoVO authLogin(String username, String password) {
        LambdaQueryWrapper<User> lqw = Wrappers.<User>lambdaQuery()
                .eq(User::getPassword, password);
        lqw.and(l -> l.eq(User::getUsername, username).or().eq(User::getUserId, username));
        User user = userService.getOne(lqw);

        if (ObjectUtil.isNull(user)) {
            throw new CustomException(ErrorCodeEnum.USER_ERROR);
        }

        List<Role> roleList = roleMapper.getRoleByUserId(user.getUserId());
        Set<String> roleNameSet = new HashSet<>();

        for (Role role : roleList) {
            roleNameSet.add(role.getRoleKey());
        }

        UserInfoVO userInfoVO = user.toVO();

        return userInfoVO;
    }
}
