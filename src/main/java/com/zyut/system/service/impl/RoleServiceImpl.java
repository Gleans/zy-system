package com.zyut.system.service.impl;

import com.zyut.system.service.RoleService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyut.system.dao.RoleMapper;
import com.zyut.system.model.dto.Role;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
