package com.zyut.system.model.vo;

import cn.hutool.core.bean.BeanUtil;
import com.zyut.system.model.common.PageVO;
import com.zyut.system.model.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO extends PageVO<User> {

    private Integer userId;

    private String username;
    private String password;
    private String sex;               //性别

    private String phone;               //性别

    private String email;

    List<Integer> roleList;
    private String roleListStr;

}
