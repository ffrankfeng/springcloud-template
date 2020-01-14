package com.fengf.demo.springcloud.user.service;



import com.fengf.demo.springcloud.user.pojo.User;

import java.util.List;

public interface UserService {
    boolean insert(User user);

    boolean updateById(User user);

    User selectById(long loginUserId);

    boolean deleteById(long userId);

    List<User> selectByPage(Integer page, Integer size);
}
