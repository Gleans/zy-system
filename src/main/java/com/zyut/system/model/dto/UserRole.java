package com.zyut.system.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zyut.system.model.common.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_role")
public class UserRole extends BaseDTO {
    @TableId(value = "user_role_id", type = IdType.AUTO)
    private Integer userRoleId;

    @TableField(value = "role_id")
    private Integer roleId;

    @TableField(value = "user_id")
    private Integer userId;


    public UserRole(Integer roleId, Integer userId) {
        this.roleId = roleId;
        this.userId = userId;
    }
}