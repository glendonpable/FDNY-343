package com.fmpdroid.fdny343.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fmpdroid.fdny343.activities.LiveFeedActivity;

import java.io.IOException;

/**
 * Created by sagara213@gmail.com on 11/17/2016.
 */
public class BackgroundService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener{
    MediaPlayer mMediaPlayer = null;
    String url = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.wtf("service is started", "starting");
        url = intent.getStringExtra("feed");
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        try {
            mMediaPlayer.setDataSource(url);
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.prepareAsync();
            Log.wtf("service is preparing", "starting");
        } catch (IOException e) {
            e.printStackTrace();
        } // might take long! (for buffering, etc)
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
        stopSelf();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        Log.wtf("service commence start", "starting");
        mp.start();
        buildNotification();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    public void buildNotification(){
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0,
                new Intent(getApplicationContext(), LiveFeedActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        builder.setTicker("Test text");
        builder.setSmallIcon(android.R.drawable.ic_menu_send);
        builder.setContentInfo("info");
        builder.setContentIntent(pi);
        builder.setContentText("Content text");
        builder.setSubText("Sub Text");
        builder.setContentTitle("Title");
        Notification notification = builder.build();
        startForeground(1, notification);
    }
}