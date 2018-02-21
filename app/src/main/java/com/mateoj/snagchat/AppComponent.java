package com.mateoj.snagchat;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jose.mateoacosta on 5/22/17.
 */
@Singleton
@Component( modules = ApplicationModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
