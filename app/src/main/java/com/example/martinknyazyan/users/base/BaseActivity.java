package com.example.martinknyazyan.users.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import dagger.android.DaggerActivity;

public class BaseActivity extends DaggerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
