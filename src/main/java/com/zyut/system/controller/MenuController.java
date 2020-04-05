package com.zyut.system.controller;

import com.zyut.system.model.common.ResultBean;
import com.zyut.system.model.vo.MenuVO;
import com.zyut.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ResultBean<List<MenuVO>> getTree(Integer userId) {
        return ResultBean.success(menuService.buildTree(userId));
    }
}
