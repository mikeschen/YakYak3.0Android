package com.mikeschen.www.yakyak.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mikeschen.www.yakyak.R;
import com.mikeschen.www.yakyak.models.YakYak;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostActivity extends AppCompatActivity {
    ArrayList<YakYak> mPosts = new ArrayList<>();
    @Bind(R.id.detailPostTextView) TextView mDetailPostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);

        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        mPosts = Parcels.unwrap(getIntent().getParcelableExtra("posts"));
        mDetailPostTextView.setText("detail: " + mPosts.get(startingPosition).getPost());
    }
}
