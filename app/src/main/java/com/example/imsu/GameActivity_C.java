package com.example.imsu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity_C extends AppCompatActivity {
    private TextView playerName;
    private ImageView imgView1,imgView2,imgView3,imgView4,imgView5,imgView6;

    // set current player
    static Player currentPlayer = Player.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_c);

        playerName = findViewById(R.id.txtView_playerName);
        playerName.setText(currentPlayer.getPlayerName());
    }
}
