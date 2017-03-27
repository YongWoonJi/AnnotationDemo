package com.example.yongwoon.annotationdemo;

import android.app.Application;

import org.androidannotations.annotations.EApplication;

/**
 * Created by YongWoon on 2017-03-15.
 */

@EApplication
public class MyApplication  extends Application {

    public void onCreate() {
        super.onCreate();
    }
}
