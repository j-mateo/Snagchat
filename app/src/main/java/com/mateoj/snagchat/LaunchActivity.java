package com.mateoj.snagchat;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LaunchActivity extends AppCompatActivity {
    private static final long START_DELAY = 2 * 1000;
    private Runnable startTask = null;
    private Handler startHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }

    @Override
    protected void onStart() {
        super.onStart();
        start(AuthProvider.getInstance().isLoggedIn());
    }

    private void start(boolean isLoggedIn) {
        if (startHandler != null && startTask != null) {
            startHandler.removeCallbacks(startTask);
        }

        startHandler = new Handler(Looper.myLooper());

        if(!isLoggedIn) {
            startTask = new Runnable() {
                @Override
                public void run() {
                    AuthActivity.start(LaunchActivity.this);
                    finish();
                }
            };

        } else {
            startTask = new Runnable() {
                @Override
                public void run() {
                    //                MainActivity.start(this);

                }
            };
        }

        startHandler.postDelayed(startTask, START_DELAY);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (startHandler != null && startTask != null) {
            startHandler.removeCallbacks(startTask);
            startTask = null;
            startHandler = null;
        }
    }
}
