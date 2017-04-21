package com.mateoj.snagchat.mvp.signup;

/**
 * Created by jose.mateoacosta on 4/14/17.
 */

public interface SignupContract {
    interface SignupView {
        void showBirthdayFragment();

        void showMainActivity();
    }

    interface SignupPresenter {
        void onStop();
        void onStart();
        void nameEntered(String first, String last, String email, String password);
    }
}
