package com.zyut.system.aop;

import com.zyut.system.exception.CustomException;
import com.zyut.system.model.common.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Slf4j
@Aspect
public class ControllerAOP {

    //切点方法
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ResultBean<?> result;
        try {
            result = (ResultBean<?>) pjp.proceed();
            log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    /**
     * 封装异常信息，注意区分已知异常（自己抛出的）和未知异常
     */
    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean<>();
        log.error("错误信息",e);
        if (e instanceof CustomException) {
            return ResultBean.fail(((CustomException) e).getCodeEnum());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("错误信息[").append(e.getLocalizedMessage()).append("]错误详细信息===》").append(Arrays.toString(e.getStackTrace()));
        log.error(stringBuilder.toString());
        result.setMsg(stringBuilder.toString());
        result.setCode(ResultBean.FAIL);
        return result;
    }
}