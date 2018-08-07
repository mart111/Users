package com.example.martinknyazyan.users.di.module;

import com.example.martinknyazyan.users.MainActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ActivityModule {

    @Binds
    public abstract MainActivity getActivity(MainActivity activity);

}
