package com.xugongming38.job.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xugongming38.job.R;

public class LoginActiviyy extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiyy);
        initView();
    }

    private void initView() {
        register = (TextView)findViewById(R.id.tv_login_register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
