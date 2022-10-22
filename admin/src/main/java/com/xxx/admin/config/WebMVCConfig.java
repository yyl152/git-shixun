package com.xxx.admin.config;


import com.xxx.admin.compont.LoginIntceptor;
import com.xxx.admin.compont.TUser9Intceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Autowired
    LoginIntceptor loginIntceptor;
    @Autowired
    private TUser9Intceptor tUser9Intceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html","/admin/login","/js/*","/css/*","/fonts/*");
        registry.addInterceptor(tUser9Intceptor)
                .addPathPatterns("/tuser/*","/admin_list.html")
                .excludePathPatterns("/tuser/login");
    }
}
