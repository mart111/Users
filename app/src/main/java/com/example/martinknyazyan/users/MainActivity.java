package com.example.martinknyazyan.users;

import android.os.Bundle;

import com.example.martinknyazyan.users.base.BaseActivity;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
