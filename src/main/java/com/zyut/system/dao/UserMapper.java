package com.zyut.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyut.system.model.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}