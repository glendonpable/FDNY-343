package com.fmpdroid.fdny343.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fmpdroid.fdny343.R;
import com.fmpdroid.fdny343.activities.LiveFeedActivity;
import com.fmpdroid.fdny343.models.Frequencies;

import java.util.List;

/**
 * Created by sagara213@gmail.com on 11/20/2016.
 */
public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.FeedListViewHolder> {

    private List<Frequencies> feedList;

    public class FeedListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView frequency;

        public FeedListViewHolder(View view){
            super(view);
            frequency = (TextView) view.findViewById(R.id.feed);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(v.getContext(), LiveFeedActivity.class);
            intent.putExtra("position", position);
            v.getContext().startActivity(intent);
        }
    }

    public FeedListAdapter(List<Frequencies> feedList){
        this.feedList = feedList;
    }

    @Override
    public FeedListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_content, parent, false);

        return new FeedListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedListAdapter.FeedListViewHolder holder, int position) {
        Frequencies frequencies = feedList.get(position);
        holder.frequency.setText(frequencies.getFeed());
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }
}
