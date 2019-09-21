package com.example.imsu;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity_C extends AppCompatActivity {
    // level details
    final static int LEVEL_ID = 3;
    final static String LEVEL_NAME = Strings.level3;

    private TextView playerName;
    private Button btn_blast; // blast button
    private ImageView imgView1,imgView2,imgView3,imgView4,imgView5,imgView6; // prisms
    private ImageView imgView7; // skb
    private ImageView imgView8; // sun
    private ImageView imgView9,imgView10,imgView11,imgView12,imgView13; // light beams vertical
    private ImageView imgView14,imgView15,imgView16,imgView17,imgView18; // light beams horizontal

    static Player currentPlayer;
    static int playerScore = 30000; // player score

    Animation animFadeIn,animFadeOut; // animation class variables

    Toast levelToast; // toast declaration

    FragmentTransaction ft; // FragmentTransaction declaration

    // initial states of prisms
    private static int i1 = 3; // clockwise
    private static int i2 = 2; // clockwise
    private static int i3 = 2; // counter clockwise
    private static int i4 = 2; // counter clockwise
    private static int i5 = 3; // clockwise
    private static int i6 = 3; // counter clockwise

    private static int[] prismRotateCount = new int[]{i1,i2,i3,i4,i5,i6}; // rotate count

    private int rating = 3; // rating count

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_c);

        currentPlayer = Player.getInstance(); // set current player

        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein); // fadeIn initialization
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout); // fadeOut initialization

        playerName = findViewById(R.id.txtView_playerName);
        playerName.setText(currentPlayer.getPlayerName()); // set player name

        // set value for prisms
        imgView1 = findViewById(R.id.imgView_prism_c1);
        imgView2 = findViewById(R.id.imgView_prism_c2);
        imgView3 = findViewById(R.id.imgView_prism_c3);
        imgView4 = findViewById(R.id.imgView_prism_c4);
        imgView5 = findViewById(R.id.imgView_prism_c5);
        imgView6 = findViewById(R.id.imgView_prism_c6);

        imgView7 = findViewById(R.id.imgView_skb_c); // set value for skb
        imgView8 = findViewById(R.id.imgView_sun_c); // set value for sun

        // set value for light beams vertical
        imgView9 = findViewById(R.id.imgView_lightbeam_v1_c);
        imgView10 = findViewById(R.id.imgView_lightbeam_v2_c);
        imgView11 = findViewById(R.id.imgView_lightbeam_v3_c);
        imgView12 = findViewById(R.id.imgView_lightbeam_v4_c);
        imgView13 = findViewById(R.id.imgView_lightbeam_v5_c);

        // set value for light beams horizontal
        imgView14 = findViewById(R.id.imgView_lightbeam_h1_c);
        imgView15 = findViewById(R.id.imgView_lightbeam_h2_c);
        imgView16 = findViewById(R.id.imgView_lightbeam_h3_c);
        imgView17 = findViewById(R.id.imgView_lightbeam_h4_c);
        imgView18 = findViewById(R.id.imgView_lightbeam_h5_c);

        // hide light beams
        imgView9.setVisibility(View.INVISIBLE);
        imgView10.setVisibility(View.INVISIBLE);
        imgView11.setVisibility(View.INVISIBLE);
        imgView12.setVisibility(View.INVISIBLE);
        imgView13.setVisibility(View.INVISIBLE);
        imgView14.setVisibility(View.INVISIBLE);
        imgView15.setVisibility(View.INVISIBLE);
        imgView16.setVisibility(View.INVISIBLE);
        imgView17.setVisibility(View.INVISIBLE);
        imgView18.setVisibility(View.INVISIBLE);

        btn_blast = findViewById(R.id.btn_blast); // set blast button

        //
    }
}
