package com.mateoj.snagchat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mateoj.snagchat.mvp.login.LoginActivity;
import com.mateoj.snagchat.mvp.signup.SignupActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, AuthActivity.class));
    }

    @OnClick(R.id.login_btn)
    public void onLoginClicked() {
        LoginActivity.start(this);
    }

    @OnClick(R.id.signup_btn)
    public void onSignupClicked() {
        SignupActivity.start(this);
    }
}
