package com.xsm.loginarchitecture.lib_login.core;

import android.content.Context;

/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
public interface ILogin {

    void login(Context applicationContext, int userDefine);

    boolean isLogin(Context applicationContext);

}
