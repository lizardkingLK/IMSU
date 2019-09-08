package com.example.imsu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mainTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // theme song declaration
        mainTheme = Audio.setMediaPlayer(getApplicationContext());

        // main view buttons
        Button buttonPlay,buttonScoreBoard,buttonSettings,buttonHelp,buttonQuit;

        // Locate the buttons in activity_main.xml
        buttonPlay = findViewById(R.id.btn_Continue);
        buttonScoreBoard = findViewById(R.id.btn_ScoreBoard);
        buttonSettings = findViewById(R.id.btn_Settings);
        buttonHelp = findViewById(R.id.btn_Help);
        buttonQuit = findViewById(R.id.btn_NewGame);

        // loads Play
        buttonPlay.setOnClickListener(arg0 -> {
            System.out.println(getResources().getString(R.string.clicked_btn_Play));

            // Start NewGameActivity.class
            Intent myIntent = new Intent(MainActivity.this,
                    PlayActivity.class);
            startActivity(myIntent);
        });

        // loads ScoreBoard
        buttonScoreBoard.setOnClickListener(arg0 -> {
            System.out.println(getResources().getString(R.string.clicked_btn_Scoreboard));

            // Start ScoreBoardActivity.class
            Intent myIntent = new Intent(MainActivity.this,
                    ScoreBoardActivity.class);
            startActivity(myIntent);
        });

        // loads Settings
        buttonSettings.setOnClickListener(arg0 -> {
            System.out.println(getResources().getString(R.string.clicked_btn_Settings));

            // Start SettingsActivity.class
            Intent myIntent = new Intent(MainActivity.this,
                    SettingsActivity.class);
            startActivity(myIntent);
        });

        // loads Help
        buttonHelp.setOnClickListener(arg0 -> {
            System.out.println(getResources().getString(R.string.clicked_btn_Help));

            // Start HelpActivity.class
            Intent myIntent = new Intent(MainActivity.this,
                    HelpActivity.class);
            startActivity(myIntent);
        });

        buttonQuit.setOnClickListener(arg0 -> {
            System.out.println(getResources().getString(R.string.clicked_btn_Quit));

            System.exit(0);
        });
    }

    // theme starts playing
    @Override
    protected void onResume() {
        super.onResume();

        mainTheme.setLooping(true);
        mainTheme.start();
    }


}
