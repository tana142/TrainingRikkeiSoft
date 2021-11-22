package com.rikkei.training.activity.trainingapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Activity Main";
    private Button btnF1, btnF2;
    private Bundle bundleState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundleState = new Bundle();
        bundleState = savedInstanceState;
        btnF1 = findViewById(R.id.button_f1);
        btnF2 = findViewById(R.id.button_f2);
//
        btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.container, FragmentF1.Instance(), null)
                            .addToBackStack("F1")
                            .commit();
                }
            }
        });
        btnF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.container, FragmentF2.Instance(), null)
                            .addToBackStack("F1")
                            .commit();
                }
            }
        });

        Log.e(TAG, "onCreate: " + TAG);
    }

    static MainActivity Instance() {
        return new MainActivity();
    }


//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        Log.e(TAG, "onStart: " + TAG );
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.e(TAG, "onResume: " + TAG);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.e(TAG, "onPause: " + TAG );
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.e(TAG, "onStop: " + TAG);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.e(TAG, "onDestroy: "+ TAG );
//    }
}