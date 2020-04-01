package com.zyut.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyut.system.model.dto.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {
}