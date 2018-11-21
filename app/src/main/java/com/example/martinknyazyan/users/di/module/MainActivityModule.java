package com.example.martinknyazyan.users.di.module;

import com.example.martinknyazyan.users.main.MainActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainActivityModule {

    @Binds
    public abstract MainActivity getActivity(MainActivity activity);

}
