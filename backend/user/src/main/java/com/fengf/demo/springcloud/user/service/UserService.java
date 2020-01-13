package com.fengf.demo.springcloud.user.service;



import com.fengf.demo.springcloud.user.pojo.User;

import java.util.List;

public interface UserService {
    boolean insert(User user);

    boolean updateById(User user);

    User selectById(Integer loginUserId);

    boolean deleteById(Integer userId);

    List<User> selectByPage(Integer page, Integer size);
}
