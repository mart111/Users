package com.example.martinknyazyan.users.di.component;

import com.example.martinknyazyan.users.di.module.MyAppModule;
import com.example.martinknyazyan.users.di.module.RetrofitModule;
import com.example.martinknyazyan.users.di.module.RxModule;
import com.example.martinknyazyan.users.di.module.UserModule;
import com.example.martinknyazyan.users.main.MyApp;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        MyAppModule.class,
        RetrofitModule.class,
        RxModule.class,
        UserModule.class
})
public interface AppComponent extends AndroidInjector<MyApp> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MyApp> {
    }
}
