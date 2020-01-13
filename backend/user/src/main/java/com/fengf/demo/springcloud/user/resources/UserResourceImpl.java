package com.fengf.demo.springcloud.user.resources;

import com.fengf.common.JsonResult;
import com.fengf.common.PageResult;
import com.fengf.common.pojo.Result;
import com.fengf.demo.springcloud.user.api.UserResource;
import com.fengf.demo.springcloud.user.pojo.User;
import com.fengf.demo.springcloud.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserResourceImpl implements UserResource {

    @Autowired
    private UserService userService;

    @Override
    public PageResult<User> list(Integer page, Integer size) {
//        //执行查询
        List<User> list = userService.selectByPage(page, size);
//        //创建一个返回值对象
//        //取分页结果
        System.out.println("re page = "+page+",size = "+size);

        return new PageResult<>(list);
    }

    @Override
    public Result<String> add(String userName, String password, String email, String phone, String address) {
        System.out.println("add = " + userName);
        @Valid User user = new User(0, userName, password, email, phone, address);
        System.out.println("add = " + user);
        if (userService.insert(user)){
            return new Result<String>(0,"添加用户成功");
        }else {
            return new Result<String>(1,"添加用户失败");
        }
    }

    @Override
    public Result<String> update(Integer userId, String userName, String password, String email, String phone, String address) {
        User user = new User(userId, userName, password, email, phone, address);
        System.out.println("enter update "+user);
        if (userService.updateById(user)){
            return new Result<String>(0,"更新用户成功");
        }else {
            return new Result<String>(1,"更新用户失败");
        }
    }



    @Override
    public JsonResult updatePsw(Integer userId, String oldPsw, String newPsw, HttpServletRequest request) {
        User user = userService.selectById(userId);
        if (!DigestUtils.md5DigestAsHex(oldPsw.getBytes()).equals(user.getPassword())) {
            return JsonResult.error("原密码不正确");
        }
        user.setPassword(DigestUtils.md5DigestAsHex(newPsw.getBytes()));
        if (userService.updateById(user)) {
            return JsonResult.ok("修改成功");
        }
        return JsonResult.error("修改失败");
    }

    @Override
    public Result<String> delete(Integer userId) {
        if (userService.deleteById(userId)) {
            return new Result<String>(0,"删除用户成功");
        }else {
            return new Result<String>(1,"删除用户失败");
        }
    }


}
