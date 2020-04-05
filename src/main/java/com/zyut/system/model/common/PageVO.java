package com.zyut.system.model.common;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<T> {
    private Integer page;

    private Integer limit;

    public Integer getPage() {
        return ObjectUtil.defaultIfNull(page, 1);
    }

    public Integer getLimit() {
        return ObjectUtil.defaultIfNull(limit, 10);
    }
}
