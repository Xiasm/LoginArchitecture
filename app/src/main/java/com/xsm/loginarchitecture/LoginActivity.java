package com.xsm.loginarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xsm.loginarchitecture.util.SharePreferenceUtil;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void loginEvent(View view) {
        SharePreferenceUtil.setBooleanSp(SharePreferenceUtil.IS_LOGIN, true, this);
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void quitLogin(View view) {
        SharePreferenceUtil.clearSharePref(SharePreferenceUtil.IS_LOGIN, this);
    }
}
