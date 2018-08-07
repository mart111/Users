package com.example.martinknyazyan.users.di.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {


    @Provides
    public Retrofit getRetrofitInstance(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("http://api.randomuser.me")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    public OkHttpClient getClient(HttpLoggingInterceptor interceptor) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(interceptor);
        return client.build();
    }

    @Provides
    public HttpLoggingInterceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
