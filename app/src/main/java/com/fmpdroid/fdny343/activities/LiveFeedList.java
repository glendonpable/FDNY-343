package com.fmpdroid.fdny343.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fmpdroid.fdny343.R;
import com.fmpdroid.fdny343.adapters.FeedListAdapter;
import com.fmpdroid.fdny343.models.Frequencies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sagara213@gmail.com on 11/20/2016.
 */
public class LiveFeedList extends AppCompatActivity {

    private List<Frequencies> feedList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FeedListAdapter feedListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        feedListAdapter = new FeedListAdapter(feedList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(feedListAdapter);

        prepareFeedList();
    }


    private void prepareFeedList(){
        Frequencies frequencies = new Frequencies("FDNY Citywide Scanner");
        feedList.add(frequencies);
        frequencies = new Frequencies("Bronx Dispatch Scanner");
        feedList.add(frequencies);
        frequencies = new Frequencies("Brooklyn Dispatch Scanner");
        feedList.add(frequencies);
        frequencies = new Frequencies("Manhattan Dispatch Scanner");
        feedList.add(frequencies);
        frequencies = new Frequencies("Queens Dispatch Scanner");
        feedList.add(frequencies);
        frequencies = new Frequencies("Staten Island Dispatch Scanner");
        feedList.add(frequencies);

        feedListAdapter.notifyDataSetChanged();
    }
}
