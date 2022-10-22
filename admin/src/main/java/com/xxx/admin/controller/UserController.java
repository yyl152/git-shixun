package com.xxx.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xxx.admin.common.R;
import com.xxx.admin.mapper.UserMapper;
import com.xxx.admin.pojo.User;
import com.xxx.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/list")
    public List<User> selectAll() {
        List<User> list = userMapper.selectList(null);
        return list;
    }

    @RequestMapping("/addOne")
    public R<String> add(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(user.getQq()!=null,User::getQq,user.getQq());
        User selectOne = userMapper.selectOne(queryWrapper);
        if (selectOne!=null) {
            return R.error("qq已注册");
        }
        LambdaQueryWrapper<User> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(user.getEmail()!=null,User::getEmail,user.getEmail());
        User selectTwo = userMapper.selectOne(queryWrapper2);
        if (selectTwo!=null) {
            return R.error("email已注册");
        }

        int i = userMapper.insert(user);
        return R.success("添加成功");
    }

    @RequestMapping("/testQq")
    public R testQq(String qq) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(qq!=null,User::getQq,qq);
        User selectOne = userMapper.selectOne(queryWrapper);
        if (selectOne!=null) {
            return R.error(null);
        }
        return null;
    }


    @RequestMapping("/deleteById")
    public R<String> delete(int id) {
        int i = userMapper.deleteById(id);
        if (i == 1) {
            return R.success("删除成功");
        }
        return R.error("系统繁忙，删除失败");
    }

    @GetMapping("/selectById")
    public R<User> selectById(int id) {
        User byId = userService.getById(id);
        return R.success(byId);
    }

    @RequestMapping("/update")
    public R<String> update(User user) {
        userService.updateById(user);
        return R.success("修改成功");
    }
}
