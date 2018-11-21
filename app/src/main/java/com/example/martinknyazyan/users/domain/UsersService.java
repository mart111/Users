package com.example.martinknyazyan.users.domain;

import com.example.martinknyazyan.users.data.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface UsersService {

    String END_POINT = "https://randomuser.me/";

    @GET("api/")
    Call<User> getUsers(@Query("page") String page, @Query("results") String results, @Query("seed") String seed);

    @GET("api/?page=3&results=10&seed=abc")
    Call<User> getUsers();
}
