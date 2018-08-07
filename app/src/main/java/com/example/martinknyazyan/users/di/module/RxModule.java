package com.example.martinknyazyan.users.di.module;


import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class RxModule {


    @Provides
    public Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    public Scheduler getIoScheduler() {
        return Schedulers.io();
    }
}
