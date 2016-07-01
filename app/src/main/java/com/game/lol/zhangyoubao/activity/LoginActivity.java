package com.game.lol.zhangyoubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.game.lol.zhangyoubao.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView btnRegister;
    private EditText etName;
    private EditText etPassword;
    private Button btnLogin;
    private ImageView btnWeixin;
    private ImageView btnQq;
    private ImageView btnWeibo;

    private void assignViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnRegister = (TextView) findViewById(R.id.btn_register);
        etName = (EditText) findViewById(R.id.et_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnWeixin = (ImageView) findViewById(R.id.btn_weixin);
        btnQq = (ImageView) findViewById(R.id.btn_qq);
        btnWeibo = (ImageView) findViewById(R.id.btn_weibo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        assignViews();
        initListener();
    }

    private void initListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnWeixin.setOnClickListener(this);
        btnQq.setOnClickListener(this);
        btnWeibo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                Toast.makeText(LoginActivity.this, "点击了注册按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_login:
                Toast.makeText(LoginActivity.this, "点击了登录按钮", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_weixin:
                Toast.makeText(LoginActivity.this, "点击了微信按钮", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_qq:
                Toast.makeText(LoginActivity.this, "点击了QQ按钮", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_weibo:
                Toast.makeText(LoginActivity.this, "点击了微博按钮", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
