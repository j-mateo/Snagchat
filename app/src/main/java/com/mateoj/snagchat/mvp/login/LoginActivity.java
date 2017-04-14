package com.mateoj.snagchat.mvp.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mateoj.snagchat.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {
    private LoginContract.LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenterImp(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
