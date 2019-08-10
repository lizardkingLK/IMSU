package com.example.imsu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewGameActivity extends Activity {
    private Player newPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button buttonOK;
        final EditText editTextPlayerName;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newgame);

        // set ok button
        editTextPlayerName = findViewById(R.id.editText_newGame_playerName);
        buttonOK = findViewById(R.id.btn_oK_playerName);

        // loads new game
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playerName = editTextPlayerName.getText().toString();
                if(playerName != null) {
                    newPlayer = Player.getInstance();
                    newPlayer.setPlayerName(playerName);

                    Intent myIntent = new Intent(NewGameActivity.this, GameActivity.class);
                    startActivity(myIntent);
                }
            }
        });
    }
}
