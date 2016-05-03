package com.mikeschen.www.yakyak.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reviveit on 5/2/16.
 */
@Parcel
public class YakYak {
    String post;
    String pushId;

    public YakYak() {}

    public YakYak(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
