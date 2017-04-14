package com.mateoj.snagchat.mvp.login;

/**
 * Created by jose.mateoacosta on 4/14/17.
 */

public interface LoginContract {
    interface LoginView {

    }

    interface LoginPresenter {
        void onStop();
        void onStart();
    }
}
