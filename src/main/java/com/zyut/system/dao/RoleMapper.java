package com.zyut.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyut.system.model.dto.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRoleByUserId(Integer userId);
}