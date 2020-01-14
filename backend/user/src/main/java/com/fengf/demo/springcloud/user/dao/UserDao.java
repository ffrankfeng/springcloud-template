package com.fengf.demo.springcloud.user.dao;


import com.fengf.demo.springcloud.user.pojo.User;
import org.jooq.CaseConditionStep;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.model.Tables.USERS;

@Repository
public class UserDao {
    @Autowired
    private DSLContext dslContext;
    

    public int insert(User user) {
        return dslContext.insertInto(
                USERS,
                USERS.USERID,
                USERS.USERNAME,
                USERS.PASSWORD,
                USERS.EMAIL,
                USERS.PHONE,
                USERS.ADDRESS
        )
                .values(
                        user.getUserId(),
                        user.getUserName(),
                        user.getPassword(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getAddress()
                ).execute();
    }

    public int updateById(User user) {
        return dslContext.update(USERS)
                .set(USERS.USERNAME,user.getUserName())
                .set(USERS.PASSWORD,user.getPassword())
                .set(USERS.EMAIL,user.getEmail())
                .set(USERS.PHONE,user.getPhone())
                .set(USERS.ADDRESS, user.getAddress())
                .where(USERS.USERID.eq(user.getUserId()))
                .execute();
    }

    public int deleteById(long userId) {
        return dslContext.delete(USERS).where(USERS.USERID.eq(userId)).execute();
    }

    public List<User> selectByPage(Integer page, Integer size) {
        return dslContext.select().from(USERS).where().limit((page - 1) * size, size).fetch().into(User.class);
    }

    public List<User> selectById(long loginUSERSId) {
        return dslContext.select().from(USERS).where(USERS.USERID.eq(loginUSERSId)).fetch().into(User.class);
    }
}
