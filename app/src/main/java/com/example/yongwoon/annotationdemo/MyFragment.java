package com.example.yongwoon.annotationdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yongwoon.annotationdemo.model.Tweet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;


@EFragment(R.layout.fragment_my)
public class MyFragment extends Fragment {

    List<Tweet> list;


    @Bean
    TweetAdapter adapter;

    @ViewById(R.id.progressBar)
    ProgressBar progressBar;

    @ViewById(R.id.textFragment)
    TextView textView;

    @ViewById(R.id.recyclerView)
    RecyclerView recyclerView;

    @FragmentArg
    String text;

    @FragmentArg("number")
    int num;

    @AfterViews
    void init() {
        textView.setText(text + " " + num);
        list = new ArrayList<>();

        initData();
    }

    @UiThread
    void bindAdapter() {
        adapter.setData(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    String accessToken;
    @Background
    void initData() {
        Ion.with(this)
                .load("https://api.twitter.com/oauth2/token")
                .basicAuthentication("e4LrcHB55R3WamRYHpNfA", "MIABn1DU5db3Aj0xXzhthsf4aUKMAdoWJTMxJJcY")
                .setBodyParameter("grant_type", "client_credentials")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (e != null) {
                            Toast.makeText(getContext(), "Error loading data from server", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        accessToken = result.get("access_token").getAsString();
                        load();
                    }
                });
    }

    Future<JsonArray> loading;
    @Background
    void load() {
        String url = "https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=TWlCE_Sana&count=20";

        Ion.with(this)
                .load(url)
                .setHeader("Authorization", "Bearer " + accessToken)
                .as(new TypeToken<List<Tweet>>(){})
                .setCallback(new FutureCallback<List<Tweet>>() {
                    @Override
                    public void onCompleted(Exception e, List<Tweet> result) {
                        if (e != null) {
                            Toast.makeText(getContext(), "Error loading data from server", Toast.LENGTH_SHORT).show();
                            return;
                        }
//                        Gson gson = new Gson();
//                        list = gson.fromJson(result, new TypeToken<List<Tweet>>(){}.getType());
                        list = result;

                        bindAdapter();
                        updateUI();
                    }
                });
    }

    @UiThread
    void updateUI() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // ..
        return null;
    }

}
