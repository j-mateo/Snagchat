package com.mateoj.snagchat.mvp.signup;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.mateoj.snagchat.AuthProvider;
import com.mateoj.snagchat.MainActivity;
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
    public void nameEntered(String first, String last, String email, String password) {
        AuthProvider.getInstance().SignUp(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            view.showMainActivity();
                        } else {
                            task.getException().printStackTrace();
                        }
                    }
                });
    }
}
