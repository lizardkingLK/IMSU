package com.example.imsu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
        buttonContinue.setOnClickListener(arg0 -> {
            System.out.println(getResources().getString(R.string.clicked_btn_Continue));

            // Start ContinueActivity.class
            Intent myIntent = new Intent(PlayActivity.this,
                    PlayActivity.class);
            startActivity(myIntent);
        });

        // loads new Game
        buttonNewGame.setOnClickListener(arg0 -> {
            System.out.println(getResources().getString(R.string.clicked_btn_Play));

            // Start NewGameActivity.class
            Intent myIntent = new Intent(PlayActivity.this,
                    NewGameActivity.class);
            startActivity(myIntent);
        });

        // loads previous Levels
        buttonSelectLevel.setOnClickListener(arg0 -> {
            System.out.println(getResources().getString(R.string.clicked_btn_SelectLevel));

            // Start SelectLevelActivity.class
            Intent myIntent = new Intent(PlayActivity.this,
                    SelectLevelActivity.class);
            startActivity(myIntent);
        });
    }

}
