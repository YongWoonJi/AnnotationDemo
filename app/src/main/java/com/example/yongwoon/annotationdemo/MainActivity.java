package com.example.yongwoon.annotationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.WindowFeature;

@Fullscreen
@WindowFeature({Window.FEATURE_NO_TITLE})
@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Bean
    MainView mainView;

    @App
    MyApplication app;

    @SystemService
    WindowManager wm;

    @LongClick
    void btnSecondActivity() {
        Intent intent = SecondActivity_.intent(this).get();
        intent.putExtra("extra", 100);
        startActivity(intent);
    }

}
