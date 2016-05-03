package com.mikeschen.www.yakyak.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mikeschen.www.yakyak.R;
import com.mikeschen.www.yakyak.models.YakYak;
import com.mikeschen.www.yakyak.ui.PostDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.postTextView)
    TextView mPostTextView;

    private Context mContext;
    private ArrayList<YakYak> mPosts = new ArrayList<>();

    public PostViewHolder(View itemView, ArrayList<YakYak> posts) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mPosts = posts;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, PostDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("posts", Parcels.wrap(mPosts));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindPost(YakYak yakyak) {
        mPostTextView.setText(yakyak.getPost());
    }
}
