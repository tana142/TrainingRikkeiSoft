package com.rikkei.training.activity.trainingapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.rikkei.training.activity.trainingapplication.databinding.ActivityABinding;

public class ActivityA extends AppCompatActivity {

    private static final String TAG = "Activity A";
    private ActivityABinding binding;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_a);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_a);
        Log.e(TAG, "onCreate: " + TAG);

        mediaPlayer = MediaPlayer.create(this, R.raw.loinho);
        binding.btnActivityB.setOnClickListener(v -> startActivity(new Intent(this, ActivityB.class)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer.start();
        Log.e(TAG, "onStart: " + TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " + TAG);
    }

    @Override
    protected void onPause() {

        super.onPause();
        Log.e(TAG, "onPause: " + TAG);
    }

    @Override
    protected void onStop() {
        mediaPlayer.pause();
        super.onStop();
        Log.e(TAG, "onStop: " + TAG);
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) mediaPlayer.release();
        super.onDestroy();
        Log.e(TAG, "onDestroy: " + TAG);
    }


}