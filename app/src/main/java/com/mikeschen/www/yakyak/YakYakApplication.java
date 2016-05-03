package com.mikeschen.www.yakyak;

import android.app.Application;

import com.firebase.client.Firebase;

public class YakYakApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
