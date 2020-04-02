package com.zyut.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyut.system.model.dto.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyut.system.model.vo.RoleVO;

import java.util.List;

public interface RoleService extends IService<Role>{

    boolean addRole(RoleVO roleVO);

    IPage<RoleVO> getList(RoleVO role);

    boolean updateRole(RoleVO role);
}
