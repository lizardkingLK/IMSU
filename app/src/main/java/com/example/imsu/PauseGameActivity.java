package com.example.imsu;

import android.content.Intent;
import android.os.Bundle;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PauseGameActivity extends DialogFragment {
    public PauseGameActivity() {
        //
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View v = layoutInflater.inflate(R.layout.activity_pausegame, container, false);

        Button btnNextLevel = v.findViewById(R.id.btn_nextLevel);
        btnNextLevel.setOnClickListener(args -> {
            Intent nextLevelIntent = new Intent(getActivity(),GameActivity_A.class);
            startActivity(nextLevelIntent);
        });

        // Inflate the layout for this fragment
        return v;
    }
}
