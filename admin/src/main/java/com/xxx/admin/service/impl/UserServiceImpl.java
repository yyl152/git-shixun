package com.xxx.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.admin.common.R;
import com.xxx.admin.pojo.User;
import com.xxx.admin.service.UserService;
import com.xxx.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Yyl
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-10-10 15:16:20
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;


}




