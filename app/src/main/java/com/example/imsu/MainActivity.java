package com.example.imsu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // loads ScoreBoard
    public void loadScoreBoard(View view) {
        System.out.println(getResources().getString(R.string.clicked_btn_Scoreboard));

        // Get the view from activity_scoreboard.xml
        setContentView(R.layout.activity_scoreboard);

        // Get the correct button
        button = findViewById(R.id.btn_ScoreBoard);

        // Start ScoreBoardActivity.class
        Intent myIntent = new Intent(MainActivity.this, ScoreBoardActivity.class);
        startActivity(myIntent);
    }

    // loads Settings
    public void loadSettings(View view) {
        System.out.println(getResources().getString(R.string.clicked_btn_Settings));

        // Get the view from activity_settings.xml
        setContentView(R.layout.activity_settings);

        // Get the correct button
        button = findViewById(R.id.btn_Settings);

        // Start SettingsActivity.class
        Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(myIntent);
    }


    // loads Help
    public void loadHelp(View view) {
        System.out.println(getResources().getString(R.string.clicked_btn_Help));

        // Get the view from activity_help.xml
        setContentView(R.layout.activity_help);

        // Get the correct button
        button = findViewById(R.id.btn_help);

        // Start HelpActivity.class
        Intent myIntent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(myIntent);
    }
}
