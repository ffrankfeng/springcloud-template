package com.fengf.demo.springcloud.userfeign.controller;


import com.alibaba.fastjson.JSON;
import com.fengf.common.JsonResult;
import com.fengf.common.PageResult;
import com.fengf.common.pojo.Result;
import com.fengf.demo.springcloud.userfeign.pojo.User;
import com.fengf.demo.springcloud.userfeign.service.UserFeign;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserFeignController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("api/user")
    public String list(@RequestParam(value = "page") Integer page, @RequestParam(value = "size")Integer size, Model model){
        PageResult<User> list = userFeign.list(page, size);
        List<User> users = list.getData();
        model.addAttribute("users", users);
        System.out.println("page = "+page+",size = "+size);
        return "list";
    }

    @ResponseBody
    @PostMapping("api/user")
    public String add(@RequestBody @Valid User user){
        System.out.println("enter controller add "+user);
        Result<String> add = userFeign.add(user.getUserName(),user.getPassword(),user.getEmail(),user.getPhone(),user.getAddress());
        System.out.println("add result: " + add.message);
        return JSON.toJSONString(add);
    }

    @ResponseBody
    @PutMapping("api/user")
    public String update(@RequestBody  User user){
        System.out.println("enter update "+ user);
        Result<String> update = userFeign.update(user.getUserId(),user.getUserName(),user.getPassword(),user.getEmail(),user.getPhone(),user.getAddress());
        System.out.println("update result: " + update);
        return JSON.toJSONString(update);
    }

    @ResponseBody
    @PutMapping("api/user/psw")
    public JsonResult updatePsw(@RequestParam(value = "userId")Integer userId, @RequestParam(value = "oldPsw")String oldPsw, @RequestParam(value = "newPsw")String newPsw, HttpServletRequest request){
        return userFeign.updatePsw(userId, oldPsw, newPsw, request);
    }

    @ResponseBody
    @DeleteMapping("api/user/{id}")
    public String delete(@PathVariable("id") Integer userId){
        Result<String> delete = userFeign.delete(userId);
        System.out.println("delete result "+delete.toString());
        return JSON.toJSONString(delete);
    }
}
