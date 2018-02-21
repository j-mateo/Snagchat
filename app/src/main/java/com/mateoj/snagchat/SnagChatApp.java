package com.mateoj.snagchat;

import android.app.Application;
import android.content.Context;


/**
 * Created by jose.mateoacosta on 5/22/17.
 */

public class SnagChatApp extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static SnagChatApp get(Context context) {
        return (SnagChatApp) context.getApplicationContext();
    }
}
