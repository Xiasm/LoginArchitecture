package com.xsm.loginarchitecture.lib_login.core;

import android.content.Context;

/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
class LoginAssistant {
    private LoginAssistant() {}

    private static LoginAssistant instance;

    public static LoginAssistant getInstance() {
        if (instance == null) {
            synchronized (LoginAssistant.class) {
                if (instance == null) {
                    instance = new LoginAssistant();
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

    public void serverTokenInvalidation(int userDefine) {
        if (iLogin == null)
            return;
        iLogin.clearLoginStatus();
        iLogin.login(applicationContext, userDefine);
    }
}
