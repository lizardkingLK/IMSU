package com.example.imsu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private Player currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final ImageView imgView1,imgView2;
        final TextView textView_playerName;

        // set current player
        currentPlayer = Player.getInstance();

        // set value for prisms
        imgView1 = findViewById(R.id.imgView_prism_1);
        imgView2 = findViewById(R.id.imgView_prism_2);

        // set player name
        textView_playerName = findViewById(R.id.txtView_playerName);
        textView_playerName.setText(currentPlayer.getPlayerName());

        imgView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(getResources().getString(R.string.clicked_prism),getResources().getString(R.string.clicked_prism));

                // call to rotate the prism
                Prism.rotateClockWise(imgView1);
            }
        });

        imgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(getResources().getString(R.string.clicked_prism),getResources().getString(R.string.clicked_prism));

                // call to rotate the prism
                Prism.rotateCounterClockWise(imgView2);
            }
        });



    }
}
