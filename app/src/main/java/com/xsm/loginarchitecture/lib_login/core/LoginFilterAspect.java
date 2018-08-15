package com.xsm.loginarchitecture.lib_login.core;

import android.content.Context;

import com.xsm.loginarchitecture.lib_login.ILogin;
import com.xsm.loginarchitecture.lib_login.annotation.LoginFilter;
import com.xsm.loginarchitecture.lib_login.utils.LoginUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;


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

        ILogin iLogin = LoginUtils.getInstance().getiLogin();
        if (iLogin == null) {
            return;
        }

        LoginFilter loginFilter = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(LoginFilter.class);
        Context param = LoginUtils.getInstance().getApplicationContext();
        if (iLogin.isLogin(param)) {
            joinPoint.proceed();
        } else {
            iLogin.login(param, loginFilter.userDefine());
        }

    }

}
