package com.mikeschen.www.yakyak.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikeschen.www.yakyak.R;
import com.mikeschen.www.yakyak.models.YakYak;

import java.util.ArrayList;

public class PostListAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private ArrayList<YakYak> mPosts = new ArrayList<>();
    private Context mContext;

    public PostListAdapter(Context context, ArrayList<YakYak> posts) {
        mContext = context;
        mPosts = posts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_item, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(view, mPosts);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindPost(mPosts.get(position));
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }
}