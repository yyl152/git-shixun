package com.xxx.admin;

import com.xxx.admin.mapper.UserMapper;
import com.xxx.admin.pojo.User;
import com.xxx.admin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class AdminApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        // List<User> users = userMapper.selectList(null);
        // System.out.println(users);
        Map<String, Object> map = userService.getMap(null);
        System.out.println(map);
    }

}
