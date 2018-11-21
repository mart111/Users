package com.example.martinknyazyan.users.di.module;

import com.example.martinknyazyan.users.data.User;

import dagger.Module;

@Module
public class UserModule {

    public User provideUser() {
        return new User();
    }
}
