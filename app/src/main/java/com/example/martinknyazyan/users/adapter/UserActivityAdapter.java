package com.example.martinknyazyan.users.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.martinknyazyan.users.R;
import com.example.martinknyazyan.users.data.Result;
import com.example.martinknyazyan.users.data.User;
import com.example.martinknyazyan.users.listener.OnLoadMoreListener;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_LOADING = 1;
    private final int VIEW_TYPE_ITEM = 0;

    private OnLoadMoreListener onLoadMoreListener;
    private boolean isLoading = false;
    private Context context;
    private List<Result> results;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    public UserActivityAdapter(RecyclerView recyclerView, Context context, List<Result> results) {
        this.context = context;
        this.results = results;

        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = layoutManager.getItemCount();
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();

                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {

                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }

                    isLoading = true;

                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return results.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;

    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public void setLoaded() {
        isLoading = false;
    }


    public void addResults(User user) {
        results.addAll(user.getResults());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return (viewType == VIEW_TYPE_ITEM)
                ? new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
                : new LoadingViewHolder(LayoutInflater.from(context).inflate(R.layout.item_loading, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof UserViewHolder) {
            Result result = results.get(position);
            ((UserViewHolder) holder).surname.setText(result.getName().getLast());
            ((UserViewHolder) holder).city.setText(result.getLocation().getCity());
            ((UserViewHolder) holder).name.setText(result.getName().getFirst());
            Glide.with(context)
                    .load(result.getPicture().getLarge())
                    .apply(new RequestOptions().error(R.drawable.ic_launcher_background).circleCrop())
                    .into(((UserViewHolder) holder).userImage);
        } else if (holder instanceof LoadingViewHolder) {
            ((LoadingViewHolder) holder).progressBar.setVisibility(View.VISIBLE);

        }
    }

    public List<Result> getResults() {
        return results;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }


    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView name, surname, city;
        CircleImageView userImage;

        UserViewHolder(View itemView) {
            super(itemView);
//            Toast.makeText(context, "Insde userholder", Toast.LENGTH_SHORT).show();
            name = itemView.findViewById(R.id.name);
            surname = itemView.findViewById(R.id.surname);
            city = itemView.findViewById(R.id.city);
            userImage = itemView.findViewById(R.id.user_image);
        }
    }

    class LoadingViewHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            Toast.makeText(context, "Inside loading", Toast.LENGTH_SHORT).show();
            progressBar = itemView.findViewById(R.id.progress);

        }
    }
}
