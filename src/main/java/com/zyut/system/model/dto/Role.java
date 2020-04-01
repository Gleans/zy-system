package com.zyut.system.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role")
public class Role {
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

    /**
     * 创建人
     */
    @TableField(value = "create_id")
    private Integer createId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Integer createTime;

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
}