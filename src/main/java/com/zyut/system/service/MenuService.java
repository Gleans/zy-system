package com.zyut.system.service;

import com.zyut.system.model.dto.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyut.system.model.vo.MenuVO;

import java.util.List;

public interface MenuService extends IService<Menu>{

    List<MenuVO> buildTree(Integer userId);
}
