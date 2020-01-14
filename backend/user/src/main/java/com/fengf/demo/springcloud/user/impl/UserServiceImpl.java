package com.fengf.demo.springcloud.user.impl;

import com.fengf.common.utils.SnowFlakeUtil;
import com.fengf.demo.springcloud.user.dao.UserDao;
import com.fengf.demo.springcloud.user.pojo.User;
import com.fengf.demo.springcloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean insert(User user) {
        user.setUserId(SnowFlakeUtil.getID(1,1));
        return userDao.insert(user) > 0 ;
    }

    @Override
    public boolean updateById(User user) {
        return userDao.updateById(user) > 0 ;
    }

    @Override
    public User selectById(long loginUserId) {
        List<User> users = userDao.selectById(loginUserId);
        if (users == null)
            return null;
        else return users.get(0);
    }

    @Override
    public boolean deleteById(long userId) {
        return userDao.deleteById(userId) > 0 ;
    }

    @Override
    public List<User> selectByPage(Integer page, Integer size) {
        return userDao.selectByPage(page, size);
    }

}
