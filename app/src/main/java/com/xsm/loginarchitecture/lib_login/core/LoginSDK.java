package com.xsm.loginarchitecture.lib_login.core;

import android.content.Context;

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
        LoginAssistant.getInstance().setApplicationContext(context);
        LoginAssistant.getInstance().setiLogin(iLogin);
    }

    /**
     * 单点登录，验证token失效的统一接入入口
     */
    public void serverTokenInvalidation(int userDefine) {
        LoginAssistant.getInstance().serverTokenInvalidation(userDefine);
    }
}
