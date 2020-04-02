package com.zyut.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyut.system.model.vo.RoleVO;
import com.zyut.system.model.vo.UserInfoVO;
import com.zyut.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyut.system.dao.RoleMapper;
import com.zyut.system.model.dto.Role;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public boolean addRole(RoleVO roleVO) {
        return false;
    }

    @Override
    public IPage<RoleVO> getList(RoleVO role) {
        QueryWrapper<RoleVO> ew = new QueryWrapper<>();
        ew.orderByDesc("role_id");
        return baseMapper.query(new Page<>(role.getPage(), role.getLimit()), ew);
    }

    @Override
    public boolean updateRole(RoleVO role) {
        return false;
    }
}
