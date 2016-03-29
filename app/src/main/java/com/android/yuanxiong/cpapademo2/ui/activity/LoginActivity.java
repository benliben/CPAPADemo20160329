package com.android.yuanxiong.cpapademo2.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.yuanxiong.cpapademo2.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/3/27.
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.number)
    EditText number;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.login)
    TextView login;
    @Bind(R.id.register)
    TextView register;
    @Bind(R.id.forgetPassword)
    TextView forgetPassword;

    private Context context ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login, R.id.register, R.id.forgetPassword})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            case R.id.forgetPassword:
                startActivity(new Intent(LoginActivity.this,ForgetPasswordActivity.class));
                break;
        }
    }


}
