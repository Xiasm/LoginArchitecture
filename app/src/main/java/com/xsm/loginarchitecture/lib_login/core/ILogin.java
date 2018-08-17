package com.xsm.loginarchitecture.lib_login.core;

import android.content.Context;

/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
public interface ILogin {

    /**
     * 登录事件接收
     * @param applicationContext
     * @param userDefine
     */
    void login(Context applicationContext, int userDefine);

    /**
     * 判断是否登录
     * @param applicationContext
     * @return
     */
    boolean isLogin(Context applicationContext);

    /**
     * 清楚登录状态
     * @return
     */
    void clearLoginStatus(Context applicationContext);

}
