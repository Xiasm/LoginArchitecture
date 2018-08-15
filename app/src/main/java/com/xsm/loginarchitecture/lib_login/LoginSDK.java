package com.xsm.loginarchitecture.lib_login;

import android.content.Context;

import com.xsm.loginarchitecture.lib_login.utils.LoginUtils;

/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
public class LoginSDK {
    private static LoginSDK instance;
    private Context applicationContext;

    private LoginSDK() {}

    public static LoginSDK getInstance() {
        if (instance == null) {
            synchronized (LoginSDK.class) {
                if (instance == null) {
                    instance = new LoginSDK();
                }
            }
        }
        return instance;
    }

    public void init(Context context, ILogin iLogin) {
        applicationContext = context.getApplicationContext();
        LoginUtils.getInstance().setApplicationContext(context);
        LoginUtils.getInstance().setiLogin(iLogin);
    }
}
