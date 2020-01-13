package com.fengf.demo.springcloud.user.interceptor;

import com.fengf.common.pojo.Result;
import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 参数校验异常处理器
 *
 * fengf
 */
//@ControllerAdvice
//@ResponseBody
public class MethodArgumentNotValidExceptionInterceptor {

//    @ExceptionHandler(value = BindException.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
        String failmsg = "";
        List<FieldError> fieldErrors = ((BindException) e).getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            failmsg = failmsg + error.getDefaultMessage() + "|";

        }

        return new Result<String>(1, failmsg + '\b');
    }
}
