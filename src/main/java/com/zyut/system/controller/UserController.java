package com.zyut.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyut.system.model.common.ResultBean;
import com.zyut.system.model.dto.Role;
import com.zyut.system.model.vo.UserInfoVO;
import com.zyut.system.service.RoleService;
import com.zyut.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
    public ResultBean<IPage<UserInfoVO>> getUser(UserInfoVO user) {
        return ResultBean.success(userService.getList(user));
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBean<Boolean> addUser(@RequestBody UserInfoVO user) {
        return ResultBean.success(userService.addUser(user));
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBean<Boolean> updateUser(@RequestBody UserInfoVO user) {
        return ResultBean.success(userService.updateUser(user));
    }

    @ResponseBody
    @RequestMapping(value = "del-user", method = RequestMethod.GET)
    public ResultBean<Boolean> delUser(Integer userId) {
        return ResultBean.success(userService.removeById(userId));
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

    @RequestMapping(value = "group", method = RequestMethod.GET)
    public ModelAndView group() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("group");
        List<Role> menuList = roleService.list();
        modelAndView.addObject("menuList", menuList);
        return modelAndView;
    }

    @RequestMapping(value = "{path}", method = RequestMethod.GET)
    public ModelAndView pathMatch(@PathVariable("path") String path, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(path);
        List<Role> menuList = roleService.list();
        System.out.println(session.getAttribute("userInfo"));
        return modelAndView;
    }
}
