package com.zyut.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyut.system.model.dto.Menu;
import com.zyut.system.model.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuVO> getList(Integer userId);
}