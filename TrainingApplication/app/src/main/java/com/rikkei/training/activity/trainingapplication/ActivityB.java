package com.rikkei.training.activity.trainingapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.rikkei.training.activity.trainingapplication.databinding.ActivityABinding;
import com.rikkei.training.activity.trainingapplication.databinding.ActivityBBinding;

public class ActivityB extends AppCompatActivity {

    private static final String TAG = "Activity B";
    private ActivityBBinding binding;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_b);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_b);
        Log.e(TAG, "onCreate: " + TAG );
        mediaPlayer = MediaPlayer.create(this, R.raw.trontim);
        mediaPlayer.start();

        binding.btnActivityA.setOnClickListener(v -> finish());
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "onStart: " + TAG );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " + TAG);
    }

    @Override
    protected void onPause() {
        mediaPlayer.stop();
        super.onPause();
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
}