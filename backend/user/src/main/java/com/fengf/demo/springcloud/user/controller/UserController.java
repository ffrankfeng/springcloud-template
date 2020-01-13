//package com.fengf.demo.springcloud.user.controller;
//
//
//import com.fengf.common.JsonResult;
//import com.fengf.common.PageResult;
//import com.fengf.common.pojo.Result;
//import com.fengf.demo.springcloud.user.pojo.User;
//import com.fengf.demo.springcloud.user.service.UserService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.DigestUtils;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Api(value = "用户管理", tags = "user")
//@RestController
//@RequestMapping("api/user")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
////    @RequiresPermissions("get:/v1/user")
//    @ApiOperation(value = "查询所有用户", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer", paramType = "form"),
//            @ApiImplicitParam(name = "limit", value = "每页多少条", required = true, dataType = "Integer", paramType = "form"),
//            @ApiImplicitParam(name = "searchKey", value = "筛选条件字段", dataType = "String", paramType = "form"),
//            @ApiImplicitParam(name = "searchValue", value = "筛选条件关键字", dataType = "String", paramType = "form"),
//            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String", paramType = "form")
//    })
//    @GetMapping()
//    public PageResult<User> list(@RequestParam(value = "page") Integer page, @RequestParam(value = "size")Integer size) {
//        //执行查询
//        List<User> list = userService.selectByPage(page, size);
//        //创建一个返回值对象
//        //取分页结果
//        return new PageResult<>(list);
//    }
//
////    @RequiresPermissions("post:/v1/user")
//    @ApiOperation(value = "添加用户", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User", paramType = "form"),
//            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String", paramType = "form")
//    })
//    @PostMapping()
//    public Result<String> add(@RequestBody User user) {
//        System.out.println("add user : "+user);
//        if (userService.insert(user)){
//            return new Result<String>(0,"新增用户成功");
//        }else {
//            return new Result<String>(1,"新增用户失败");
//        }
//    }
//
////    @RequiresPermissions("put:/v1/user")
//    @ApiOperation(value = "修改用户", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User", paramType = "form"),
//            @ApiImplicitParam(name = "roleId", value = "用户角色id", required = true, dataType = "String", paramType = "form"),
//            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String", paramType = "form")
//    })
//    @PutMapping()
//    public Result<String> update(@RequestBody User user) {
//        System.out.println("enter update "+user);
//        if (userService.updateById(user)){
//            return new Result<String>(0,"更新用户成功");
//        }else {
//            return new Result<String>(1,"更新用户失败");
//        }
//    }
//
//
////    @RequiresPermissions("put:/v1/user/psw")
//    @ApiOperation(value = "修改自己密码", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "oldPsw", value = "原密码", required = true, dataType = "String", paramType = "form"),
//            @ApiImplicitParam(name = "newPsw", value = "新密码", required = true, dataType = "String", paramType = "form"),
//            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String", paramType = "form")
//    })
//    @PutMapping("/psw")
//    public JsonResult updatePsw(@RequestParam(value = "userId")Integer userId, @RequestParam(value = "oldPsw")String oldPsw, @RequestParam(value = "newPsw")String newPsw, HttpServletRequest request) {
//        User user = userService.selectById(userId);
//        if (!DigestUtils.md5DigestAsHex(oldPsw.getBytes()).equals(user.getPassword())) {
//            return JsonResult.error("原密码不正确");
//        }
//        user.setPassword(DigestUtils.md5DigestAsHex(newPsw.getBytes()));
//        if (userService.updateById(user)) {
//            return JsonResult.ok("修改成功");
//        }
//        return JsonResult.error("修改失败");
//    }
//
//
//
////    @RequiresPermissions("delete:/v1/user/{id}")
//    @ApiOperation(value = "删除用户", notes = "")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "path"),
//            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String", paramType = "form")
//    })
//    @DeleteMapping("/{id}")
//    public Result<String> delete(@PathVariable("id") Integer userId) {
//        if (userService.deleteById(userId)) {
//            return new Result<String>(0,"删除用户成功");
//        }else {
//            return new Result<String>(1,"删除用户失败");
//        }
//    }
//}
