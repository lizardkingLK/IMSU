package com.example.imsu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button buttonContinue,buttonNewGame,buttonSelectLevel;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // Locate the buttons in activity_main.xml
        buttonContinue = findViewById(R.id.btn_Continue);
        buttonNewGame = findViewById(R.id.btn_NewGame);
        buttonSelectLevel = findViewById(R.id.btn_SelectLevel);

        // loads recent Level
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                System.out.println(getResources().getString(R.string.clicked_btn_Continue));

                // Start ContinueActivity.class
                Intent myIntent = new Intent(PlayActivity.this,
                        PlayActivity.class);
                startActivity(myIntent);
            }
        });

        // loads new Game
        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                System.out.println(getResources().getString(R.string.clicked_btn_Play));

                // Start NewGameActivity.class
                Intent myIntent = new Intent(PlayActivity.this,
                        NewGameActivity.class);
                startActivity(myIntent);
            }
        });

        // loads previous Levels
        buttonSelectLevel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                System.out.println(getResources().getString(R.string.clicked_btn_SelectLevel));

                // Start SelectLevelActivity.class
                Intent myIntent = new Intent(PlayActivity.this,
                        SelectLevelActivity.class);
                startActivity(myIntent);
            }
        });
    }

//    // loads SelectLevel
//    public void loadSelectLevel(View view) {
//        System.out.println(getResources().getString(R.string.clicked_btn_SelectLevel));
//
//        // Get the view from activity_selectLevel.xml
//        setContentView(R.layout.acivity_selectlevel);
//
//        // Get the correct button
//        button = findViewById(R.id.btn_SelectLevel);
//
//        // Start SelectLevel.class
//        Intent myIntent = new Intent(PlayActivity.this, SelectLevelActivity.class);
//        startActivity(myIntent);
//    }
//
//    // loads NewGame
//    public void loadNewGame(View view) {
//        System.out.println(getResources().getString(R.string.clicked_btn_NewGame));
//
//        // Get the view from activity_newGame.xml
//        setContentView(R.layout.activity_newgame);
//
//        // Get the correct button
//        button = findViewById(R.id.btn_NewGame);
//
//        // Start NewGame.class
//        Intent myIntent = new Intent(PlayActivity.this, NewGameActivity.class);
//        startActivity(myIntent);
//    }
}
