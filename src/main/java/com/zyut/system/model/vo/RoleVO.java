package com.zyut.system.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zyut.system.model.common.PageVO;
import com.zyut.system.model.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVO extends PageVO<User> {
    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    private String roleName;
    /**
     * 角色名称key
     */
    @TableField(value = "role_key")
    private String roleKey;

}
