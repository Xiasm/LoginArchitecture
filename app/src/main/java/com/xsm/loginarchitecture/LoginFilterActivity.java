package com.xsm.loginarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.xsm.loginarchitecture.lib_login.annotation.LoginFilter;

public class LoginFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (lib_login_filter_onCreate(true)) {
            Toast.makeText(this, "没有登录！", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @LoginFilter
    public Boolean lib_login_filter_onCreate(Boolean aspectParam) { return aspectParam; }
}
