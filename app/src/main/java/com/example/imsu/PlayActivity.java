package com.example.imsu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends Activity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    // loads SelectLevel
    public void loadSelectLevel(View view) {
        System.out.println(getResources().getString(R.string.clicked_btn_SelectLevel));

        // Get the view from activity_selectLevel.xml
        setContentView(R.layout.acivity_selectlevel);

        // Get the correct button
        button = findViewById(R.id.btn_SelectLevel);

        // Start SelectLevel.class
        Intent myIntent = new Intent(PlayActivity.this, SelectLevelActivity.class);
        startActivity(myIntent);
    }

    // loads NewGame
    public void loadNewGame(View view) {
        System.out.println(getResources().getString(R.string.clicked_btn_NewGame));

        // Get the view from activity_newGame.xml
        setContentView(R.layout.activity_newgame);

        // Get the correct button
        button = findViewById(R.id.btn_NewGame);

        // Start NewGame.class
        Intent myIntent = new Intent(PlayActivity.this, NewGameActivity.class);
        startActivity(myIntent);
    }
}
