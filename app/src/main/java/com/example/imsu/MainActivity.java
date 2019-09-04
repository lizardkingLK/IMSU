package com.example.imsu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button buttonPlay,buttonScoreBoard,buttonSettings,buttonHelp,buttonQuit;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Locate the buttons in activity_main.xml
        buttonPlay = findViewById(R.id.btn_Continue);
        buttonScoreBoard = findViewById(R.id.btn_ScoreBoard);
        buttonSettings = findViewById(R.id.btn_Settings);
        buttonHelp = findViewById(R.id.btn_Help);
        buttonQuit = findViewById(R.id.btn_NewGame);

        // loads Play
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                System.out.println(getResources().getString(R.string.clicked_btn_Play));

                // Start NewGameActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        PlayActivity.class);
                startActivity(myIntent);
            }
        });

        // loads ScoreBoard
        buttonScoreBoard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                System.out.println(getResources().getString(R.string.clicked_btn_Scoreboard));

                // Start ScoreBoardActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        ScoreBoardActivity.class);
                startActivity(myIntent);
            }
        });

        // loads Settings
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                System.out.println(getResources().getString(R.string.clicked_btn_Settings));

                // Start SettingsActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        SettingsActivity.class);
                startActivity(myIntent);
            }
        });

        // loads Help
        buttonHelp.setOnClickListener(new View.OnClickListener() {
           public void onClick(View arg0) {
               System.out.println(getResources().getString(R.string.clicked_btn_Help));

               // Start HelpActivity.classs
               Intent myIntent = new Intent(MainActivity.this,
                       HelpActivity.class);
               startActivity(myIntent);
           }
        });

        buttonQuit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                System.out.println(getResources().getString(R.string.clicked_btn_Quit));

                System.exit(0);
            }
        });
    }

}
