package com.zyut.system.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zyut.system.model.vo.UserInfoVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User {
    /**
     * 表主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private Long phone;

    /**
     * 创建人
     */
    @TableField(value = "create_id")
    private Integer createId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Long createTime;

    /**
     * 创建人
     */
    @TableField(value = "update_id")
    private Integer updateId;

    /**
     * 创建时间
     */
    @TableField(value = "update_time")
    private Long updateTime;

    /**
     * 删除状态 Y/N
     */
    @TableField(value = "is_delete")
    private String isDelete;

    public UserInfoVO toVO() {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUserId(this.getUserId());
        userInfoVO.setUsername(this.getUsername());
        userInfoVO.setSex(this.getSex());
        userInfoVO.setEmail(this.getEmail());
        return userInfoVO;
    }
}