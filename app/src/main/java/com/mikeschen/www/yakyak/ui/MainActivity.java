package com.mikeschen.www.yakyak.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.mikeschen.www.yakyak.Constants;
import com.mikeschen.www.yakyak.R;
import com.mikeschen.www.yakyak.adapters.FirebasePostListAdapter;
import com.mikeschen.www.yakyak.models.YakYak;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ValueEventListener mSearchedPostRefListener;
    private Firebase mSearchedPostRef;
    @Bind(R.id.postEditText) EditText mPostEditText;
    @Bind(R.id.postButton) Button mPostButton;
    private Query mQuery;
    private Firebase mFirebasePostsRef;
    private FirebasePostListAdapter mAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchedPostRef = new Firebase(Constants.FIREBASE_URL_ADDED_POST);
        mPostButton.setOnClickListener(this);
        mFirebasePostsRef = new Firebase(Constants.FIREBASE_URL_POSTS);

        setUpFirebaseQuery();
        setUpRecyclerView();

        mSearchedPostRefListener = mSearchedPostRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String posts = dataSnapshot.getValue().toString();
                Log.d("Post updated", posts);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void setUpFirebaseQuery() {
        String post = mFirebasePostsRef.toString();
        Log.d("retrieving post", post);
        mQuery = new Firebase(post);
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebasePostListAdapter(mQuery, YakYak.class);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedPostRef.removeEventListener(mSearchedPostRefListener);
    }

    @Override
    public void onClick(View v) {
        if (v == mPostButton) {
            String post = mPostEditText.getText().toString();
            savePostToFirebase(post);
            Toast.makeText(MainActivity.this, "Posted", Toast.LENGTH_SHORT).show();
        }
    }
    public void savePostToFirebase(String post) {
        YakYak newPostList = new YakYak(post);
        Firebase ref = new Firebase(Constants.FIREBASE_URL_ADDED_POST);
        Firebase newListRef = ref.push();
        String pushId = newListRef.getKey();
        newPostList.setPushId(pushId);
        newListRef.setValue(newPostList);
//        ref.push().setValue(post);
    }
}
