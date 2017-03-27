package com.example.yongwoon.annotationdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by YongWoon on 2017-03-15.
 */

public class Tweet  {
    @SerializedName("retweeted_status")
    Tweet retweetedStatus;
    User user;
    String text;
    @SerializedName("id_str")
    String id;

    public Tweet getRetweetedStatus() {
        return retweetedStatus;
    }

    public void setRetweetedStatus(Tweet retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
