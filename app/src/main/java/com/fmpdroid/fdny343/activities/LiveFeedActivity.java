package com.fmpdroid.fdny343.activities;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fmpdroid.fdny343.R;
import com.fmpdroid.fdny343.service.BackgroundService;

import org.w3c.dom.Text;

import java.io.IOException;

/**
 * Created by sagara213@gmail.com on 11/17/2016.
 */
public class LiveFeedActivity extends AppCompatActivity {
    Intent intent, playbackIntent;
    private String statenDispatch = "http://relay.broadcastify.com:80/767302395.mp3";
    private String bronxDispatch = "http://relay.broadcastify.com:80/651036824.mp3";
    private String brooklynDispatch = "http://relay.broadcastify.com:80/487177012.mp3";
    private String queensDispatch = "http://relay.broadcastify.com:80/559875149.mp3";
    private String manhattanDispatch = "http://relay.broadcastify.com:80/962912934.mp3";
    private String cityWide = "http://relay.broadcastify.com:80/838989288.mp3";
    int position;
    String frequency;
    TextView scanner;
    ImageButton btnPlay, btnPause;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livefeed);

        scanner = (TextView) findViewById(R.id.dispatch_description);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnPause = (ImageButton) findViewById(R.id.btnPause);
        scanner.setSelected(true);
        playbackIntent = new Intent(LiveFeedActivity.this, BackgroundService.class);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
                Toast.makeText(LiveFeedActivity.this, "Live radio initializing", Toast.LENGTH_SHORT).show();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(playbackIntent);
            }
        });

    }

    private void init(){
        intent = getIntent();
        position = intent.getIntExtra("position", 0);

        switch(position){
            case 0:
                frequency = cityWide;
                break;
            case 1:
                frequency = bronxDispatch;
                break;
            case 2:
                frequency = brooklynDispatch;
                break;
            case 3:
                frequency = manhattanDispatch;
                break;
            case 4:
                frequency = queensDispatch;
                break;
            case 5:
                frequency = statenDispatch;
                break;
        }


        playbackIntent.putExtra("feed", frequency);
        startService(playbackIntent);
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}

