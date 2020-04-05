package com.zyut.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyut.system.model.dto.User;
import com.zyut.system.model.vo.UserInfoVO;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {

    User getUserByUserName(String name);

    IPage<UserInfoVO> getList(UserInfoVO user);

    boolean addUser(UserInfoVO user);

    boolean updateUser(UserInfoVO user);
}
