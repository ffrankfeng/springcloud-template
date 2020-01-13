package com.fengf.demo.springcloud.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户基本信息")
public class User {
    @ApiModelProperty("用户id")
    private Integer userId;  // 用户id

    @NotNull(message = "传入的userName为null，请传值")
    @NotEmpty(message = "传入的userName为空字符串，请传值")
    @ApiModelProperty("用户名")
    private String userName;  // 账号

    @NotNull(message = "传入的password为null，请传值")
    @NotEmpty(message = "传入的password为空字符串，请传值")
    @ApiModelProperty("密码")
    private String password;  // 密码

    @NotNull(message = "传入的email为null，请传值")
    @NotEmpty(message = "传入的email为空字符串，请传值")
    @ApiModelProperty("Email")
    private String email;

    @NotNull(message = "传入的phone为null，请传值")
    @NotEmpty(message = "传入的phone为空字符串，请传值")
    @Length(min =11, max = 11, message = "传入的电话号码长度有误，必须为11位")
    @ApiModelProperty("联系方式")
    private String phone;

    @NotNull(message = "传入的address为null，请传值")
    @NotEmpty(message = "传入的address为空字符串，请传值")
    @ApiModelProperty("地址")
    private String address;
}