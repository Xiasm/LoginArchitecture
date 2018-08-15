package com.xsm.loginarchitecture.lib_login.utils;

import android.content.Context;

import com.xsm.loginarchitecture.lib_login.ILogin;

/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
public class LoginUtils {
    private LoginUtils() {}

    private static LoginUtils instance;

    public static LoginUtils getInstance() {
        if (instance == null) {
            synchronized (LoginUtils.class) {
                if (instance == null) {
                    instance = new LoginUtils();
                }
            }
        }
        return instance;
    }

    private ILogin iLogin;

    public ILogin getiLogin() {
        return iLogin;
    }

    public void setiLogin(ILogin iLogin) {
        this.iLogin = iLogin;
    }

    private Context applicationContext;

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }
}
