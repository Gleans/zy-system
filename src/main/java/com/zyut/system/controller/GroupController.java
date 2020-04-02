package com.zyut.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyut.system.model.common.ResultBean;
import com.zyut.system.model.vo.RoleVO;
import com.zyut.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("group")
public class GroupController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ResultBean<IPage<RoleVO>> getRole(RoleVO Role) {
        return ResultBean.success(roleService.getList(Role));
    }

    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBean<Boolean> addRole(@RequestBody RoleVO roleVO) {
        return ResultBean.success(roleService.addRole(roleVO));
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultBean<Boolean> updateRole(@RequestBody RoleVO Role) {
        return ResultBean.success(roleService.updateRole(Role));
    }

    @ResponseBody
    @RequestMapping(value = "del-role", method = RequestMethod.GET)
    public ResultBean<Boolean> delRole(Integer RoleId) {
        return ResultBean.success(roleService.removeById(RoleId));
    }
}
