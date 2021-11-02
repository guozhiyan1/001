package com.bjpowernode.springboot.config;

import java.lang.annotation.*;
//type代表放在类上，method代表可以放在方法上
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperLog {
    String module() default ""; //操作模块
    String operator() default "";//操作人
}
