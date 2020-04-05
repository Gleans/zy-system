package com.zyut.system.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "menu")
public class MenuVO {
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    @TableField(value = "id")
    private Integer id;

    @TableField(value = "label")
    private String label;

    @TableField(value = "path")
    private String path;

    @TableField(value = "pid")
    private Integer pid;

    @TableField(value = "type")
    private String type;

    private List<MenuVO> childMenus;

}