package com.rikkei.training.activity.trainingapplication;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentF2 extends Fragment {

    private static final String TAG = "Fragment F2";
    private Button btnF1;
    private MediaPlayer mediaPlayer;
    int position = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_f2, container, false);


        position = getArguments().getInt("position");

        Log.e(TAG, "onCreateView: ");
        // Inflate the layout for this fragment
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.loinho);
        btnF1 = view.findViewById(R.id.btn_f1);
        btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Bundle bundle = new Bundle();
               bundle.putInt("position", position);
               FragmentF1 fragmentF1 = FragmentF1.Instance();
               fragmentF1.setArguments(bundle);

                getParentFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.container, fragmentF1)
                        .commit();
            }
        });
        return view;

    }
    public static FragmentF2 Instance() {
        return new FragmentF2();
    };

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        mediaPlayer.start();
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        Log.e(TAG, "onDestroy: ");
    }
}