package com.rikkei.training.activity.trainingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.rikkei.training.activity.trainingapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String  TAG = "Activity Main";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        setContentView(R.layout.activity_main);
       Log.e(TAG, "onCreate: " + TAG );
       binding.btnActA.setOnClickListener(v -> startActivity(new Intent(this, ActivityA.class)));
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