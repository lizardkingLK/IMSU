package com.example.imsu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final ImageView imgView1,imgView2,imgView3,imgView4_earth,imgView5_skb;
        final TextView textView_playerName;

        // set current player
        Player currentPlayer = Player.getInstance();

        // set value for prisms
        imgView1 = findViewById(R.id.imgView_prism_1);
        imgView2 = findViewById(R.id.imgView_prism_2);
        imgView3 = findViewById(R.id.imgView_prism_3);
        imgView4_earth = findViewById(R.id.imgView_earth);
        imgView5_skb = findViewById(R.id.imgView_skb);

        Animation animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);

        // load skb
        animFadeIn.reset();
        imgView5_skb.clearAnimation();
        imgView5_skb.startAnimation(animFadeIn);

        // rotating earth
        Animation rotate = AnimationUtils.loadAnimation(GameActivity.this, R.anim.rotate_imsu);
        rotate.setFillAfter(true);
        imgView4_earth.startAnimation(rotate);

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

        imgView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(getResources().getString(R.string.clicked_prism),getResources().getString(R.string.clicked_prism));

                // call to rotate the prism
                Prism.rotateClockWise(imgView3);
            }
        });
    }

}
