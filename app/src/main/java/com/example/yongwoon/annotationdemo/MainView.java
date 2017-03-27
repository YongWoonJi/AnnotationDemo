package com.example.yongwoon.annotationdemo;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.AnimationRes;

/**
 * Created by YongWoon on 2017-03-16.
 */

@EBean
public class MainView {

    @RootContext
    Context context;

    @ViewById(R.id.textView)
    TextView textView;

    @ViewById(R.id.editText)
    EditText editText;

    @AnimationRes
    Animation fadeIn;

    @UiThread(delay = 1000)
    void updateTextView(String name) {
        textView.setText("제 이름은 " + name + " 입니다");
        textView.startAnimation(fadeIn);
    }

    @Background
    void initAnimation() {
        fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in);
    }

    @AfterViews
    void init() {
        initAnimation();
    }

    @Click
    void btnClick() {
        updateTextView(editText.getText().toString());
    }
}
