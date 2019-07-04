package com.lc.admin.service.impl;

import com.lc.admin.entity.User;
import com.lc.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @auth liuchong
 * @data 2019-07-03 11:04
 **/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        userService.save(user);
        assertNotNull(user.getId());
    }

    @Test
    public void findById() {
    }
}