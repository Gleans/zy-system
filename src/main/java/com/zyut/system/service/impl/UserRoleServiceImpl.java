package com.zyut.system.service.impl;

import com.zyut.system.service.UserRoleService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyut.system.dao.UserRoleMapper;
import com.zyut.system.model.dto.UserRole;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
