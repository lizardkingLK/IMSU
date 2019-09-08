package com.example.imsu;

import android.content.Intent;
import android.os.Bundle;

import android.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLevelCompleted extends DialogFragment {

    public FragmentLevelCompleted() {
        // Required empty public constructor
        //
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        View v = layoutInflater.inflate(R.layout.fragment_fragment_level_completed, container, false);

        Button btnNextLevel = v.findViewById(R.id.btn_nextLevel);
        btnNextLevel.setOnClickListener(args -> {
            Intent nextLevelIntent = new Intent(getActivity(),GameActivity_B.class);
            startActivity(nextLevelIntent);
        });

        // Inflate the layout for this fragment
        return v;
    }


}
