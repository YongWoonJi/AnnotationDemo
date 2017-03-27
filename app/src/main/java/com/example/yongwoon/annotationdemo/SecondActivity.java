package com.example.yongwoon.annotationdemo;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FragmentByTag;

@EActivity(R.layout.activity_second)
public class SecondActivity extends AppCompatActivity {

    @Extra("extra")
    int extra;

    @FragmentByTag("Tag")
    MyFragment myFragment;


    @AfterInject
    void afterInject() {
        Log.i(getApplicationContext().getPackageName(), "extra = " + extra);
    }


    @AfterViews
    void init() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MyFragment_.builder().num(100).text("argument").build(), "Tag")
                .commit();

    }

}
