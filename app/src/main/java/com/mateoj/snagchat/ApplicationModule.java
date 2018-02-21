package com.mateoj.snagchat;

import android.app.Application;


import dagger.Module;

/**
 * Created by jose.mateoacosta on 5/22/17.
 */
@Module
public class ApplicationModule {
    final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

}
