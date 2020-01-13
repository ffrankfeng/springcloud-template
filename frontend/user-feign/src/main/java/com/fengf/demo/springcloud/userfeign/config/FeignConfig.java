package com.fengf.demo.springcloud.userfeign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class FeignConfig implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String header_authorization = request.getHeader("Authorization");
        String param_access_token = request.getParameter("access_token");
        //添加token
        if (header_authorization != null){
            requestTemplate.header("Authorization", header_authorization);
        }else if (param_access_token != null){
            requestTemplate.header("Authorization", "Bearer "+param_access_token);
        }
        System.out.println("FeignConfig : header_authorization : " + header_authorization);
        System.out.println("FeignConfig : param_access_token: " + param_access_token);
    }
}
