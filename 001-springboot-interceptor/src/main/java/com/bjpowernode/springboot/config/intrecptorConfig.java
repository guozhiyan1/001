package com.bjpowernode.springboot.config;

import com.bjpowernode.springboot.intercptor.userintercptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //定义此类为配置文件（相当于xml配置文件）
public class intrecptorConfig implements WebMvcConfigurer {
    //mvc:interceptor
    @Override
    //入参是拦截器注册类,要把自己定义的拦截器注册类定义进去
    public void addInterceptors(InterceptorRegistry registry) {
        //所有user下请求都要拦截
        String[] addPathPatterns={
                "/user/**"
        };
        //排除不需要登录就可以访问的路径
        String[] excludePathPatterns={
                "/user/out","/user/nopermission","/user/login"
        };
        registry.addInterceptor(new userintercptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
