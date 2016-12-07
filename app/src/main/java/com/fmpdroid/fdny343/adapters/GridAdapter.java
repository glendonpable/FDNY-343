package com.fmpdroid.fdny343.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fmpdroid.fdny343.R;


/**
 * Created by sagara213@gmail.com on 11/17/2016.
 */
public class GridAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mTopics;
    private int[] mImageid;

    public GridAdapter(Context context, String[] topics, int[] imageid){
        mContext = context;
        mTopics = topics;
        mImageid = imageid;
    }

    @Override
    public int getCount() {
        return mTopics.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater)mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_content, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setText(mTopics[position]);
            imageView.setImageResource(mImageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
