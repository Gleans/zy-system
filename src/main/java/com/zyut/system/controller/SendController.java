package com.zyut.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SendController {

    @RequestMapping(value = "redirect/{path}", method = RequestMethod.GET)
    public ModelAndView auth(@PathVariable("path") String path, HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
//        if (ObjectUtil.isNull(request.getAttribute("userInfo"))) {
//            view.setViewName("index");
//            view.addObject("msg", "需要登陸！");
//            return view;
//        }
        view.setViewName("main");
        return view;
    }

    @RequestMapping(value = "teacher", method = RequestMethod.GET)
    public ModelAndView teacher() {
        ModelAndView view = new ModelAndView();
        view.setViewName("teacher");
        return view;
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin");
        return view;
    }
}
