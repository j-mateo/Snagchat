package com.mateoj.snagchat.mvp.login;

/**
 * Created by jose.mateoacosta on 4/14/17.
 */

public class LoginPresenterImp implements LoginContract.LoginPresenter {
    private final LoginContract.LoginView view;

    public LoginPresenterImp(LoginContract.LoginView loginView) {
        this.view  = loginView;
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onStart() {

    }
}
