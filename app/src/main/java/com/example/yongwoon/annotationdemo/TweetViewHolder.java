package com.example.yongwoon.annotationdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yongwoon.annotationdemo.model.Tweet;


public class TweetViewHolder extends RecyclerView.ViewHolder {

    Context context;
    ImageView imageView;
    TextView textName, textView;

    public TweetViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        textName = (TextView) itemView.findViewById(R.id.textName);
        textView = (TextView) itemView.findViewById(R.id.textView);
    }

    public void setData(Tweet t) {
        if (t != null) {
            if (!TextUtils.isEmpty(t.getUser().getImageUrl())) {
                Glide.with(context).load(t.getUser().getImageUrl()).into(imageView);
            }
            if (!TextUtils.isEmpty(t.getUser().getScreenName())) {
                textName.setText(t.getUser().getScreenName());
            }
            if (!TextUtils.isEmpty(t.getText())) {
                textView.setText(t.getText());
            }
        }
    }
}
