package com.xsm.loginarchitecture.lib_login.core;

import android.content.Context;

import com.xsm.loginarchitecture.lib_login.annotation.LoginFilter;
import com.xsm.loginarchitecture.lib_login.execption.AnnotationException;
import com.xsm.loginarchitecture.lib_login.execption.NoInitException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;


/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
@Aspect
public class LoginFilterAspect {
    private static final String TAG = "LoginFilterAspect";
    // && @annotation(loginFilter)
    @Pointcut("execution(@com.xsm.loginarchitecture.lib_login.annotation.LoginFilter * *(..))")
    public void loginFilter() {}

    @Around("loginFilter()")
    public void aroundLoginPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        ILogin iLogin = LoginAssistant.getInstance().getiLogin();
        if (iLogin == null) {
            throw new NoInitException("LoginSDK 没有初始化！");
        }

        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new AnnotationException("LoginFilter 注解只能用于方法上");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        LoginFilter loginFilter = methodSignature.getMethod().getAnnotation(LoginFilter.class);
        if (loginFilter == null) {
            return;
        }

        Context param = LoginAssistant.getInstance().getApplicationContext();

        if (iLogin.isLogin(param)) {
            joinPoint.proceed();
        } else {
            iLogin.login(param, loginFilter.userDefine());
        }

    }

}
