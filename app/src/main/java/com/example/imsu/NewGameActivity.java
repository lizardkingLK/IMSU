package com.example.imsu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewGameActivity extends Activity {
    private Player newPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newgame);

        final Button buttonOK;
        final EditText editTextPlayerName;

        // set ok button
        editTextPlayerName = findViewById(R.id.editText_newGame_playerName);
        buttonOK = findViewById(R.id.btn_oK_playerName);

        // loads new game
        buttonOK.setOnClickListener(view -> {
            String playerName = editTextPlayerName.getText().toString();

            Toast playerNameToast = Toast.makeText(getApplicationContext(), playerName, Toast.LENGTH_LONG);
            playerNameToast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 16);

            if (playerName.isEmpty()) {
                playerNameToast.setText(getResources().getString(R.string.warning_enterName));
                playerNameToast.show();
            }
            else {
                playerNameToast.show();

                newPlayer = Player.getInstance();
                newPlayer.setPlayerName(playerName);

                Intent myIntent = new Intent(NewGameActivity.this, GameActivity_A.class);
                startActivity(myIntent);
            }
        });

    }

}
