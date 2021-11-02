package com.bjpowernode.springboot.web;

import com.bjpowernode.springboot.config.OperLog;
import com.bjpowernode.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @RequestMapping(value="/login")
    @OperLog(module="登录",operator = "test")
    public @ResponseBody Object login(HttpServletRequest request){
        User user=new User();
        user.setId(1001);
        user.setUsername("zhangshan");
        //将用户信息存在在session中
        request.getSession().setAttribute("user",user);
        return "loin success!";
    }
    //登录后才能访问
    @RequestMapping(value="/center")
    public @ResponseBody Object center(){
        return "See Centor";
    }
    //登录前可以访问
    @RequestMapping(value="/out")
    public @ResponseBody Object out(){
        return "Out See Anytime";
    }
    //无全限跳转页面
    @RequestMapping(value="/nopermission")
    public @ResponseBody Object nopermission(){
        return "No Permission";
    }
}
