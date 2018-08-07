package com.example.martinknyazyan.users;


import com.example.martinknyazyan.users.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MyApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends MyApp> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
