package com.xsm.loginarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.xsm.loginarchitecture.lib_login.annotation.LoginFilter;
import com.xsm.loginarchitecture.lib_login.core.LoginAssistant;

public class LoginFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LoginAssistant.getInstance().getiLogin().isLogin(getApplicationContext())) {
            //TODO: 你可以想做什么就做什么，在这里我让页面结束，并给用户提示
            Toast.makeText(this, "没有登录！", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}
