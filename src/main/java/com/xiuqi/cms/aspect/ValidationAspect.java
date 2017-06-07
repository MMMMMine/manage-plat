package com.xiuqi.cms.aspect;

import com.alibaba.fastjson.JSONObject;
import com.xiuqi.cms.constant.XiuConstant;
import com.xiuqi.cms.dto.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Created by frank on 2017/6/7.
 */
@Component
@Aspect
public class ValidationAspect {

    private Logger Log = LoggerFactory.getLogger(this.getClass());

    /**
     * @Author Frank
     * @Date 2017/6/7 下午4:21
     * @Description 切点处理需要验证的接口入参
     */
    @Around("execution(* com.xiuqi.cms.controller.*.*(..))")
    public Object validateController(ProceedingJoinPoint joinPoint) throws Throwable {
        //判断入参有没有BindingResult
        BindingResult bindingResult = null;
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length != 0) {
            for (Object object : args) {
                if (object instanceof BindingResult) {
                    bindingResult = (BindingResult) object;
                    break;
                }
            }
        }
        if (bindingResult != null && bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String targetName = joinPoint.getTarget().getClass().getSimpleName();
            String method = joinPoint.getSignature().getName();
            Log.error("验证失败.控制器:{}, 方法:{}, 请求参数:{}, 属性:{}, 错误信息:{}", targetName, method,
                    JSONObject.toJSONString(bindingResult.getTarget()), fieldError.getField(), fieldError.getDefaultMessage());
            return new Result(XiuConstant.FAIL_CODE, fieldError.getDefaultMessage());
        }
        return joinPoint.proceed();
    }

}
