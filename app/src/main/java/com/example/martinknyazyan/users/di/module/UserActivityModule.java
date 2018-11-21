package com.example.martinknyazyan.users.di.module;

import com.example.martinknyazyan.users.activities.UserActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class UserActivityModule {

    @Binds
    public abstract UserActivity bindUserActivity(UserActivity userActivity);
}
