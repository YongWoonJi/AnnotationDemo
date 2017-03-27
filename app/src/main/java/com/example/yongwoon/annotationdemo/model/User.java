package com.example.yongwoon.annotationdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by YongWoon on 2017-03-15.
 */

public class User {
    @SerializedName("screen_name")
    String screenName;
    @SerializedName("profile_image_url")
    String imageUrl;

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
