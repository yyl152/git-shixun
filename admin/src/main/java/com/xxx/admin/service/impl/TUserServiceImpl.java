package com.xxx.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.admin.pojo.TUser;
import com.xxx.admin.service.TUserService;
import com.xxx.admin.mapper.TUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Yyl
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-10-13 20:02:28
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService{

}




