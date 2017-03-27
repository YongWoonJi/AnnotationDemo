package com.example.yongwoon.annotationdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yongwoon.annotationdemo.model.Tweet;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by YongWoon on 2017-03-15.
 */

@EBean
public class TweetAdapter extends RecyclerView.Adapter<TweetViewHolder> {

    @RootContext
    Context context;

    List<Tweet> list;

    @Background
    public void setData(List<Tweet> list) {
        this.list = list;
    }

    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder, parent, false);
        TweetViewHolder holder = new TweetViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TweetViewHolder holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
