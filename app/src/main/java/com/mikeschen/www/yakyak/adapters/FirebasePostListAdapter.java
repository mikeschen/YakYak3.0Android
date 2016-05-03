package com.mikeschen.www.yakyak.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Query;
import com.mikeschen.www.yakyak.R;
import com.mikeschen.www.yakyak.models.YakYak;
import com.mikeschen.www.yakyak.util.FirebaseRecyclerAdapter;

public class FirebasePostListAdapter extends FirebaseRecyclerAdapter<PostViewHolder, YakYak> {
    public FirebasePostListAdapter(Query query, Class<YakYak> itemClass) {
        super(query, itemClass);
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_list_item, parent, false);
        return new PostViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindPost(getItem(position));
    }

    @Override
    protected void itemAdded(YakYak item, String key, int position) {

    }

    @Override
    protected void itemChanged(YakYak oldItem, YakYak newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(YakYak item, String key, int position) {

    }

    @Override
    protected void itemMoved(YakYak item, String key, int oldPosition, int newPosition) {

    }
}