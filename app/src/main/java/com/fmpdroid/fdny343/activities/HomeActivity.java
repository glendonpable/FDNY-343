package com.fmpdroid.fdny343.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.fmpdroid.fdny343.R;
import com.fmpdroid.fdny343.adapters.GridAdapter;

public class HomeActivity extends AppCompatActivity {

    GridView gridView;
    String[] topics = {"Live Feed", "10 Codes", "NY Map", "Fallen 343", "Fire Stations"};
    int[] images = {android.R.drawable.ic_menu_gallery, android.R.drawable.ic_menu_send, android.R.drawable.ic_menu_send,
            android.R.drawable.ic_menu_send, android.R.drawable.ic_menu_send};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GridAdapter gridAdapter = new GridAdapter(HomeActivity.this, topics, images);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(HomeActivity.this, LiveFeedList.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(HomeActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(HomeActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(HomeActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(HomeActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
