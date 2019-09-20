package com.example.imsu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.gridlayout.widget.GridLayout;

public class SelectLevelActivity extends Activity {
    GridLayout levelsGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_selectlevel);

        levelsGridLayout = findViewById(R.id.v);

        levelsGridLayout.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
        levelsGridLayout.setRowCount(2);
        levelsGridLayout.setColumnCount(2);

        for(int i=0;i<levelsGridLayout.getChildCount();i++) {
            View x = levelsGridLayout.getChildAt(i);

        }
    }
}
