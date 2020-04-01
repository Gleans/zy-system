package com.zyut.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyut.system.model.common.ResultBean;
import com.zyut.system.model.dto.Menu;
import com.zyut.system.model.dto.Role;
import com.zyut.system.model.dto.User;
import com.zyut.system.model.vo.UserInfoVO;
import com.zyut.system.service.MenuService;
import com.zyut.system.service.RoleService;
import com.zyut.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ResultBean<IPage<User>> getUser(UserInfoVO user) {
        return ResultBean.success(userService.getList(user));
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBean<Boolean> addUser(@RequestBody UserInfoVO user) {
        return ResultBean.success(userService.addUser(user));
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView loginUser(Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("userId", userId);
        return modelAndView;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        List<Role> menuList = roleService.list();
        modelAndView.addObject("menuList", menuList);
        return modelAndView;
    }
}
