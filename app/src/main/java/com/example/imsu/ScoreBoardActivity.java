package com.example.imsu;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreBoardActivity extends Activity {

    private TextView txtNameScore;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.activity_scoreboard);


        txtNameScore = findViewById(R.id.txtNameScore);


    }

    public void viewAll(){

    }
}
