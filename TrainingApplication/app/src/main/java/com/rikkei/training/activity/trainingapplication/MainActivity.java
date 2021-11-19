package com.rikkei.training.activity.trainingapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String  TAG = "Activity Main";
    private MediaPlayer mediaPlayer = new MediaPlayer();
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Log.e(TAG, "onCreate: " + TAG );
       if(savedInstanceState == null){

           mediaPlayer = MediaPlayer.create(this, R.raw.trontim);
       }
        Log.e(TAG, "unCheck ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " + TAG );
    }

    @Override
    protected void onResume() {
        super.onResume();

        mediaPlayer.start();
        Log.e(TAG, "onResume: " + TAG);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mediaPlayer.pause();
        Log.e(TAG, "onPause: " + TAG );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " + TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: "+ TAG );
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState: "+ TAG );
        outState.putInt("position", mediaPlayer.getCurrentPosition());
        Log.e(TAG, "onSaveInstanceState: " + mediaPlayer.getCurrentPosition() );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState: "+ TAG );
        position = savedInstanceState.getInt("position");
        mediaPlayer.seekTo(position);
    }
}