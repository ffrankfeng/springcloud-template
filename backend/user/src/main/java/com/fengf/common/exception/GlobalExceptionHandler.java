//package com.fengf.common.exception;
//
//import com.fengf.common.JsonResult;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.wf.jwtp.exception.TokenException;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 全局异常处理器
// * Created by wangfan on 2018-02-22 上午 11:29.
// */
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");
//
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public JsonResult errorHandler(Exception ex, HttpServletResponse response) {
//        JsonResult jsonResult = new JsonResult();
//        // 根据不同错误获取错误信息
//        if (ex instanceof IException) {
//            jsonResult.setCode(((IException) ex).getCode());
//            jsonResult.setMessage(ex.getMessage());
//        } else if (ex instanceof TokenException) {
//            jsonResult.setCode(((TokenException) ex).getCode());
//            jsonResult.setMessage(ex.getMessage());
//        } else {
//            jsonResult.setCode(500);
//            String message = ex.getMessage();
//            jsonResult.setMessage(message == null || message.trim().isEmpty() ? "未知错误" : message);
//            logger.error(message, ex);
////            ex.printStackTrace();
//        }
//        // 支持跨域
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, Authorization");
//        return jsonResult;
//    }
//
//}
