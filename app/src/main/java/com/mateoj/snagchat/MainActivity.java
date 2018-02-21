package com.mateoj.snagchat;

import android.arch.lifecycle.LifecycleActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SnagChatApp.get(this)
                .getAppComponent()
                .inject(this);

        setContentView(R.layout.activity_main);


        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, CameraFragment.newInstance())
                    .commit();

    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

}
