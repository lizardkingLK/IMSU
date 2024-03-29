package com.example.imsu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewGameActivity extends Activity {
    private Player newPlayer;
    DatabaseHelper imsuDb;

    Button buttonOK;
    EditText editTextPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newgame);


        imsuDb = new DatabaseHelper(this);


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
                addData();

                newPlayer = Player.getInstance();
                newPlayer.setPlayerName(playerName);

                Intent myIntent = new Intent(NewGameActivity.this, GameActivity_A.class);
                startActivity(myIntent);
            }
        }
        );

    }

    //set method for button
    public void addData(){
        buttonOK.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imsuDb.insertData(editTextPlayerName.getText().toString(),0,0,1,0);
                    }
                }
        );
    }

}
