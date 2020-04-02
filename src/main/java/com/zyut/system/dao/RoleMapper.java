package com.zyut.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyut.system.model.dto.Role;
import com.zyut.system.model.vo.RoleVO;
import com.zyut.system.model.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRoleByUserId(Integer userId);

    IPage<RoleVO> query(Page<RoleVO> page,@Param("ew") QueryWrapper<RoleVO> ew);
}