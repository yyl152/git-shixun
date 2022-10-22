package com.xxx.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xxx.admin.common.R;
import com.xxx.admin.mapper.TUserMapper;
import com.xxx.admin.pojo.TUser;
import com.xxx.admin.pojo.User;
import com.xxx.admin.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/tuser")
public class TUserController {

    @Autowired
    private TUserService tUserService;
    @Autowired
    private TUserMapper tUserMapper;

    @RequestMapping("/login")
    public R<String> login(HttpSession httpSession, TUser tUser) {

        TUser user = tUserMapper.selectById(tUser);
        if (user==null){
            return R.error("密码错误");
        }else{
            // session.setAttribute("admin",user);
            httpSession.setAttribute("tuser",user);
            return R.success("登录成功");
        }

    }

    @ResponseBody
    @GetMapping("/list")
    public List<TUser> selectAll() {
        List<TUser> list = tUserMapper.selectList(null);
        return list;
    }

    @RequestMapping("/deleteById")
    public R<String> delete(int id) {
        int i = tUserMapper.deleteById(id);
        if (i == 1) {
            return R.success("删除成功");
        }
        return R.error("系统繁忙，删除失败");
    }

    @RequestMapping("/addOne")
    public R<String> add(TUser user) {

        int i = tUserMapper.insert(user);
        return R.success("添加成功");
    }

    @GetMapping("/selectById")
    public R<TUser> selectById(int id) {
        TUser byId = tUserService.getById(id);
        return R.success(byId);
    }

    @RequestMapping("/update")
    public R<String> update(TUser user) {
        tUserService.updateById(user);
        return R.success("修改成功");
    }

}
