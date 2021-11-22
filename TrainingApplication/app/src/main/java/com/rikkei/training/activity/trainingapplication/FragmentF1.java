package com.rikkei.training.activity.trainingapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentF1 extends Fragment {
    private static final String TAG = "Fragment F1";

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private Button btnF2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_f1, container, false);
        Log.e(TAG, "onCreateView: " + TAG);




        mediaPlayer = MediaPlayer.create(getContext(), R.raw.trontim);

        if(this.getArguments() != null){
            mediaPlayer.seekTo(getArguments().getInt("position"));
        }

        btnF2 = view.findViewById(R.id.btn_f2);
        btnF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("position", mediaPlayer.getCurrentPosition());


                FragmentF2 fragmentF2 =  FragmentF2.Instance();
                fragmentF2.setArguments(bundle);
                        getParentFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.container, fragmentF2)
                        .commit();
            }
        });
        return view;
    }
    public static FragmentF1 Instance(){

        return new FragmentF1();
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: " + TAG);
    }

    @Override
    public void onStart() {
        super.onStart();
        mediaPlayer.start();
        Log.e(TAG, "onStart: " + TAG);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " + TAG);
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.pause();
        Log.e(TAG, "onPause: " + TAG);
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.e(TAG, "onStop: " + TAG);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){

            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Log.e(TAG, "onDestroy: " + TAG);
    }
}