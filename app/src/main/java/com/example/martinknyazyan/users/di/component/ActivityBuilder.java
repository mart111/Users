package com.example.martinknyazyan.users.di.component;

import com.example.martinknyazyan.users.activities.UserActivity;
import com.example.martinknyazyan.users.di.module.MainActivityModule;
import com.example.martinknyazyan.users.di.module.UserActivityModule;
import com.example.martinknyazyan.users.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    public abstract MainActivity bindActivity();

    @ContributesAndroidInjector(modules = UserActivityModule.class)
    public abstract UserActivity bindUserActivity();

}
