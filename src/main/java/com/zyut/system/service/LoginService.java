package com.zyut.system.service;

import com.zyut.system.model.dto.User;
import com.zyut.system.model.vo.UserInfoVO;

public interface LoginService {
    UserInfoVO authLogin(String username, String password);
}
