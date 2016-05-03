package com.mikeschen.www.yakyak.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
    @Bind(R.id.replyEditText) EditText mReplyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);

        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        mPosts = Parcels.unwrap(getIntent().getParcelableExtra("posts"));
        mDetailPostTextView.setText("Post: " + mPosts.get(startingPosition).getPost());
    }

    @Override
        public void onClick(View view) {
            String reply = mReplyEditText.getText().toString();
            saveReplyToFirebase(reply);
    }
}
