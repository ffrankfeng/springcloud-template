package com.fengf.demo.springcloud.userfeign.service;

import com.fengf.common.JsonResult;
import com.fengf.common.PageResult;
import com.fengf.common.pojo.Result;
import com.fengf.demo.springcloud.userfeign.pojo.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "user-service")
public interface UserFeign {

    @GetMapping("api/user")
    public PageResult<User> list(@RequestParam(value = "page") Integer page, @RequestParam(value = "size")Integer size);

    @PostMapping("api/user")
    public Result<String> add(@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password,@RequestParam(value = "email") String email,@RequestParam(value = "phone") String phone,@RequestParam(value = "address") String address);

//    @PutMapping("api/user")
    @RequestMapping(value = "api/user/{userId}", method = RequestMethod.PUT)
    public Result<String> update(@PathVariable("userId")Long userId,@RequestParam(value = "userName") String userName,@RequestParam(value = "password") String password,@RequestParam(value = "email") String email,@RequestParam(value = "phone") String phone,@RequestParam(value = "address") String address);

    @PutMapping("api/user/psw")
    public JsonResult updatePsw(@RequestParam(value = "userId")Long userId, @RequestParam(value = "oldPsw")String oldPsw, @RequestParam(value = "newPsw")String newPsw, HttpServletRequest request);

    @DeleteMapping("api/user/{id}")
    public Result<String> delete(@PathVariable("id") Long userId);
    }
