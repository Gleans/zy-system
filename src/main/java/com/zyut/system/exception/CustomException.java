package com.zyut.system.exception;

import com.zyut.system.model.error.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CustomException extends RuntimeException {

    private int code;
    private String msg;
    private ErrorCodeEnum codeEnum;


    public CustomException(String message) {
        super(message);
    }

    public CustomException(ErrorCodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
        this.codeEnum = codeEnum;
    }

    public CustomException(ErrorCodeEnum codeEnum, String customMsg) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
        this.msg = customMsg;
        this.codeEnum = codeEnum;
    }

}
