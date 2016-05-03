package com.mikeschen.www.yakyak.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.mikeschen.www.yakyak.Constants;
import com.mikeschen.www.yakyak.R;
import com.mikeschen.www.yakyak.models.YakYak;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<YakYak> mPosts = new ArrayList<>();
    @Bind(R.id.detailPostTextView) TextView mDetailPostTextView;
    @Bind(R.id.replyEditText) EditText mReplyEditText;
    @Bind(R.id.replyButton) Button mReplyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.bind(this);
        mReplyButton.setOnClickListener(this);


        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        mPosts = Parcels.unwrap(getIntent().getParcelableExtra("posts"));
        mDetailPostTextView.setText("Post: " + mPosts.get(startingPosition).getPost());
    }

    @Override
        public void onClick(View view) {
            if(view == mReplyButton) {
                String reply = mReplyEditText.getText().toString();
                saveReplyToFirebase(reply);
                Toast.makeText(PostActivity.this, "Replied", Toast.LENGTH_SHORT).show();
        }
    }
    public void saveReplyToFirebase(String reply) {
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));

        mPosts = Parcels.unwrap(getIntent().getParcelableExtra("posts"));
        String postId = mPosts.get(startingPosition).getPushId();

        Firebase addedReplyRef = new Firebase(Constants.FIREBASE_URL_REPLIES).child(postId);
        Firebase replyRef = addedReplyRef.push();
        String replyPushId = replyRef.getKey();
        addedReplyRef.push().setValue(reply);
        //create new reply from String reply
        //set id to replyPushId

//        addedReplyRef.child(replyRef).push().setValue(reply);
    }
}
