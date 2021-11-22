package com.rikkei.training.activity.trainingapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String  TAG = "Activity Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedInstanceState == null){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.container, Fragment1.Instance())
                            .commit();
                }
            }
        });
       Log.e(TAG, "onCreate: " + TAG );
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