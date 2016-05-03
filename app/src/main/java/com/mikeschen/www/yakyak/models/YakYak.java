package com.mikeschen.www.yakyak.models;

import org.parceler.Parcel;

/**
 * Created by reviveit on 5/2/16.
 */
@Parcel
public class YakYak {
    String post;

    public YakYak() {}

    public YakYak(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }
}
