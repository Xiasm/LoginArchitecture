package com.xsm.loginarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExtendsLoginFilterActivity extends LoginFilterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extends_login_filter);
    }
}
