package com.example.martinknyazyan.users.di.module;


import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MyAppModule {

    @Provides
    public Context getApplication(Application application) {
        return application;
    }
}
