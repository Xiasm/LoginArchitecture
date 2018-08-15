package com.xsm.loginarchitecture.lib_login.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginFilter {

    int userDefine() default 0;

}
