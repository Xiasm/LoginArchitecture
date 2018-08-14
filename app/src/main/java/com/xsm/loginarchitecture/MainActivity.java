package com.xsm.loginarchitecture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xsm.loginarchitecture.lib_login.annotation.LoginFilter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @LoginFilter(userDefine = 0, loginFinishDefine = 0)
    public void skip(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

}
