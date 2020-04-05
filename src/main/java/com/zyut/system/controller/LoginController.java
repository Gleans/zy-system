package com.zyut.system.controller;

import cn.hutool.core.util.ObjectUtil;
import com.zyut.system.model.common.ResultBean;
import com.zyut.system.model.dto.User;
import com.zyut.system.model.vo.UserInfoVO;
import com.zyut.system.service.LoginService;
import com.zyut.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("system")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultBean<UserInfoVO> studentLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request) {

        UserInfoVO result = loginService.authLogin(username, password);
        request.getSession().setAttribute("userInfo", result);

        return ResultBean.success(result);
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView studentLogin(Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        if(ObjectUtil.isNotNull(userId)){
          User user = userService.getById(userId);
            modelAndView.addObject("userName", ObjectUtil.defaultIfBlank(user.getUsername(), "游客"));
        }
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

}