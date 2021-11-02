package com.bjpowernode.springboot.config;

import com.bjpowernode.springboot.utils.HttpContextUtils;
import com.bjpowernode.springboot.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
@Aspect //切面有切点和增强组成
@Slf4j
public class LogAspect {
    //这个注解加在哪那里就是切点
    @Pointcut("@annotation(com.bjpowernode.springboot.config.OperLog)")
    public void pt(){

    }
    //环绕通知 通知类标识切点
    @Around("pt()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Long begintime=System.currentTimeMillis();
        Object result=joinPoint.proceed();
        long time=System.currentTimeMillis()-begintime;
        recordLog(joinPoint,time);
       return result;
    }

    private void recordLog(ProceedingJoinPoint joinPoint,long time){
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        OperLog operLog=method.getAnnotation(OperLog.class);
        log.info("module：{}",operLog.module());
        log.info("operator：{}",operLog.operator());
        //请求的方法名
        String className=joinPoint.getTarget().getClass().getName();
        String methodName=signature.getName();
        log.info("request method:{}",className+"."+methodName+"{}");
        //请求的参数
        Object[] args=joinPoint.getArgs();//获取带参数方法的参数
        //String params=JSON.toJSONString(args[0]);
        List<Object> argsList=new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            // 如果参数类型是请求和响应的http，则不需要拼接【这两个参数，使用JSON.toJSONString()转换会抛异常】
            if (args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse)
            {
                continue;
            }
            argsList.add(args[i]);
        }
        log.info("params{}",argsList);
        //获取request 设置ip地址
        HttpServletRequest request= HttpContextUtils.getHttpServletRequest();
        log.info("ip:{}", IpUtils.getIpAddr(request));

        log.info("execute time:{}ms",time);




    }
}
