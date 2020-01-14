package com.fengf.demo.springcloud.userfeign.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class User {

    private Long userId;  // 用户id

    @NotNull(message = "传入的userName为null，请传值")
    @NotEmpty(message = "传入的userName为空字符串，请传值")
    private String userName;  // 账号

    @NotNull(message = "传入的password为null，请传值")
    @NotEmpty(message = "传入的password为空字符串，请传值")
    private String password;  // 密码

    @NotNull(message = "传入的email为null，请传值")
    @NotEmpty(message = "传入的email为空字符串，请传值")
    private String email;

    @NotNull(message = "传入的phone为null，请传值")
    @NotEmpty(message = "传入的phone为空字符串，请传值")
    @Length(min =11, max = 11, message = "传入的电话号码长度有误，必须为11位")
    private String phone;

    @NotNull(message = "传入的address为null，请传值")
    @NotEmpty(message = "传入的address为空字符串，请传值")
    private String address;
}