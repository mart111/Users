package com.example.martinknyazyan.users.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.martinknyazyan.users.R;
import com.example.martinknyazyan.users.adapter.UserActivityAdapter;
import com.example.martinknyazyan.users.base.BaseActivity;
import com.example.martinknyazyan.users.data.Result;
import com.example.martinknyazyan.users.data.User;
import com.example.martinknyazyan.users.domain.UsersService;
import com.example.martinknyazyan.users.listener.OnLoadMoreListener;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends BaseActivity {

    private static final String RESULTS = "5";
    private static final String SEED = "abc";
    private static String PAGE = "1";
    @Inject
    UsersService service;
    private RecyclerView recyclerView;
    private UserActivityAdapter userAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        recyclerView = findViewById(R.id.rec_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchData();
        userAdapter = new UserActivityAdapter(recyclerView, getApplicationContext(), new ArrayList<Result>());
        recyclerView.setAdapter(userAdapter);

        userAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {

                int page = Integer.parseInt(PAGE);
                Toast.makeText(getApplicationContext(), "Page Loaded: " + page, Toast.LENGTH_LONG).show();
                PAGE = String.valueOf(++page);
                fetchData(PAGE);

            }

        });
    }

    private void fetchData(String page) {

        userAdapter.getResults().add(null);
        userAdapter.notifyItemInserted(userAdapter.getResults().size() - 1);

        service.getUsers(page, RESULTS, SEED).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                final User user = response.body();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        userAdapter.getResults().remove(userAdapter.getResults().size() - 1);
                        userAdapter.notifyDataSetChanged();
                        userAdapter.addResults(user);
                        userAdapter.notifyDataSetChanged();
                        userAdapter.setLoaded();
                    }
                }, 2000);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t, Toast.LENGTH_LONG).show();

            }
        });
    }

    private void fetchData() {
        service.getUsers(PAGE, RESULTS, SEED).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                userAdapter.addResults(user);
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t, Toast.LENGTH_LONG).show();

            }
        });
    }

}


