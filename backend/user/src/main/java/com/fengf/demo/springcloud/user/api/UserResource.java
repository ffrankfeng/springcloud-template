package com.fengf.demo.springcloud.user.api;

import com.fengf.common.JsonResult;
import com.fengf.common.PageResult;
import com.fengf.common.pojo.Result;
import com.fengf.demo.springcloud.user.pojo.User;
import io.swagger.annotations.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Api(tags = "USER", description = "用户接口")
@RequestMapping("api/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserResource {

    @ApiOperation(value = "查询所有用户", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页多少条", required = true, dataType = "int", paramType = "query"),
//            @ApiImplicitParam(name = "access_token", value = "令牌", required = true, dataType = "String", paramType = "form")
    })
    @GetMapping()
    public PageResult<User> list(
            @RequestParam(value = "page")
                    Integer page,
            @RequestParam(value = "size")
                    Integer size
    );

    @ApiOperation(value = "添加用户", notes = "")
    @PostMapping()
    public Result<String> add(
            @RequestParam(value = "userName")
                    String userName,
            @RequestParam(value = "password")
                    String password,
            @RequestParam(value = "email")
                    String email,
            @RequestParam(value = "phone")
                    String phone,
            @RequestParam(value = "address")
                    String address

    );

    @ApiOperation(value = "修改用户", notes = "")
    @PutMapping()
    public Result<String> update(
                    Integer userId,
                    String userName,
                    String password,
                    String email,
                    String phone,
                    String address
    );

    @ApiOperation(value = "修改自己密码", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "用户角色id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "oldPsw", value = "原密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newPsw", value = "新密码", required = true, dataType = "String", paramType = "query"),
    })
    @PutMapping("/psw")
    public JsonResult updatePsw(
            @RequestParam(value = "userId")
                    Integer userId,
            @RequestParam(value = "oldPsw")
                    String oldPsw,
            @RequestParam(value = "newPsw")
                    String newPsw,
            HttpServletRequest request
    );


    @ApiOperation(value = "删除用户", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String", paramType = "path"),
    })
    @DeleteMapping("/{id}")
    public Result<String> delete(
            @PathVariable("id")
                    Integer userId
    );
}
