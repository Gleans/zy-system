package com.zyut.system.model.error;


public enum ErrorCodeEnum {

    SystemError(10, "系统内部错误"),
    NotSupportGetMethod(1001, "不支持GET请求"),
    MissingRequiredParameters(1002, "缺少必须参数"),
    InvalidParameter(1003, "参数值不合法"),
    ValidateFailed(1004, "验证失败"),
    // 系统
    LOGIN_ERROR(1005, "登录失败!"),
    USER_ERROR(1006, "用户名或者密码错误!"),
    USERNAME_UNQ(1007, "用户名不能重复!"),
    ;

    private final int code;
    private final String msg;

    ErrorCodeEnum(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
