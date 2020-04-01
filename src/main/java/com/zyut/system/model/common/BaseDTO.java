package com.zyut.system.model.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class BaseDTO {
    @TableLogic
    @TableField("is_delete")
    private String isDetele;
}
