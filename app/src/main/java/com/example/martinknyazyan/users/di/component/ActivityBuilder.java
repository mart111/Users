package com.example.martinknyazyan.users.di.component;

import com.example.martinknyazyan.users.MainActivity;
import com.example.martinknyazyan.users.di.module.ActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = ActivityModule.class)
    public abstract MainActivity bindActivity();

}
