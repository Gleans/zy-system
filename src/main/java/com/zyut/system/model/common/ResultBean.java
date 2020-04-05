package com.zyut.system.model.common;

import com.zyut.system.model.error.ErrorCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 *
 * description :  返回实体
 * @author: Robot
 * @date 17:41 2020/3/29
 **/
@Data
@NoArgsConstructor
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 0;

    public static final int FAIL = -1;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }

    public ResultBean<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultBean<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public ResultBean<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResultBean<T> fail(ErrorCodeEnum codeEnum) {
        return new ResultBean<T>()
                .setCode(codeEnum.getCode())
                .setMsg(codeEnum.getMsg());
    }

    public static <T> ResultBean<T> fail(ErrorCodeEnum codeEnum, T data) {
        return new ResultBean<T>()
                .setCode(codeEnum.getCode())
                .setMsg(codeEnum.getMsg())
                .setData(data);
    }

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<>(data);
    }
}
