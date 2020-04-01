package com.zyut.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyut.system.dao.MenuMapper;
import com.zyut.system.model.dto.Menu;
import com.zyut.system.model.vo.MenuVO;
import com.zyut.system.service.MenuService;
import com.zyut.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private UserService userService;

    @Override
    public List<MenuVO> buildTree(Integer userId) {

        List<MenuVO> rootMenu = baseMapper.getList(userId);
        // 构建好的菜单树，第一层菜单的pid是0
        return buildMenuTree(rootMenu, 0);
    }

    /*
     *
     * description : 构建菜单树
     * @author: Robot
     * @date 22:43 2020/3/30
     **/
    private List<MenuVO> buildMenuTree(List<MenuVO> menuList, Integer pid) {
        List<MenuVO> treeList = new ArrayList<>();
        menuList.forEach(menu -> {
            if (Objects.equals(pid, menu.getPid())) {
                menu.setChildMenus(buildMenuTree(menuList, menu.getId()));
                treeList.add(menu);
            }
        });
        return treeList;
    }
}
