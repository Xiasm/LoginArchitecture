package com.xsm.loginarchitecture.lib_login.core;

import android.content.Context;

import com.xsm.loginarchitecture.lib_login.ILogin;
import com.xsm.loginarchitecture.lib_login.LoginSDK;
import com.xsm.loginarchitecture.lib_login.annotation.LoginFilter;
import com.xsm.loginarchitecture.lib_login.execption.NoInitException;
import com.xsm.loginarchitecture.lib_login.utils.LoginUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
@Aspect
public class LoginFilterAspect {
    private static final String TAG = "LoginFilterAspect";

    @Pointcut("execution(@com.xsm.loginarchitecture.lib_login.annotation.LoginFilter * *(..)) && @annotation(loginFilter)")
    public void loginFilter(LoginFilter loginFilter) {

    }

    @Around("loginFilter(LoginFilter loginFilter)")
    public void aroundLoginPoint(final ProceedingJoinPoint joinPoint, LoginFilter loginFilter) {
        if (loginFilter == null) {
            return;
        }
        ILogin iLogin = LoginUtils.getInstance().getiLogin();
        if (iLogin == null) {
            return;
        }
        try {
            Context param = LoginUtils.getInstance().getApplicationContext();
            if (iLogin.isLogin(param)) {
                joinPoint.proceed();
            } else {
                iLogin.login(param, loginFilter.userDefine());
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}
