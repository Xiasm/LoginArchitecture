package com.xsm.loginarchitecture.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.xsm.loginarchitecture.LoginActivity;
import com.xsm.loginarchitecture.util.SharePreferenceUtil;
import com.xsm.loginarchitecture.lib_login.core.ILogin;
import com.xsm.loginarchitecture.lib_login.core.LoginSDK;

/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LoginSDK.getInstance().init(this, iLogin);
    }

    ILogin iLogin = new ILogin() {
        @Override
        public void login(Context applicationContext, int userDefine) {
            switch (userDefine) {
                case 0:
                    startActivity(new Intent(applicationContext, LoginActivity.class));
                    break;
                case 1:
                    Toast.makeText(applicationContext, "您还没有登录，请登陆后执行", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(applicationContext, "执行失败，因为您还没有登录！", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public boolean isLogin(Context applicationContext) {
            return SharePreferenceUtil.getBooleanSp(SharePreferenceUtil.IS_LOGIN, applicationContext);
        }
    };

}
