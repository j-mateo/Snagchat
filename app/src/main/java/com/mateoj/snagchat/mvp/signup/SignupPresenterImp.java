package com.mateoj.snagchat.mvp.signup;

import com.mateoj.snagchat.mvp.login.LoginContract;

/**
 * Created by jose.mateoacosta on 4/14/17.
 */

public class SignupPresenterImp implements SignupContract.SignupPresenter {
    private final SignupContract.SignupView view;
    private String firstName;
    private String lastName;

    public SignupPresenterImp(SignupContract.SignupView signupView) {
        this.view  = signupView;
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void nameEntered(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        view.showBirthdayFragment();
    }
}
