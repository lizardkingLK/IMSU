package com.example.imsu;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity_B extends AppCompatActivity implements GameActivity {
    // level details
    final static int LEVEL_ID = 2;
    final static String LEVEL_NAME = Strings.level2;

    private TextView playerName;
    private Button btn_blast; // blast button
    private Button btn_nextLevel; // next level button
    private ImageView imgView1,imgView2,imgView3,imgView4; // prisms
    private ImageView imgView5,imgView6; // skb
    private ImageView imgView7,imgView8; // threeWays
    private ImageView imgView9,imgView10; // bridges
    private ImageView imgView11; // planetX
    private ImageView imgView12; // jupiter
    private ImageView imgView13; // venus
    private ImageView imgView14,imgView15,imgView16,imgView17,imgView18,imgView19,imgView20,imgView21,imgView22,imgView23,imgView24; // light beams vertical
    private ImageView imgView25,imgView26,imgView27,imgView28,imgView29,imgView30,imgView31,imgView32,imgView33; // light beams horizontal
    private ImageView imgView34,imgView35,imgView36; // rating stars

    static Player currentPlayer;
    static int playerScore = 30000; // player score

    Animation animFadeIn,animFadeOut,rotate; // animation class variables

    Toast levelToast; // toast declaration

    FragmentTransaction ft; // FragmentTransaction declaration

    // initial states of prisms
    private static int i1 = 3; // clockwise
    private static int i2 = 3; // counter clockwise
    private static int i3 = 3; // clockwise
    private static int i4 = 2; // counter clockwise

    private static int i5 = 2,i6 = 3; // threeWays clockwise
    private static int i7 = 2,i8 = 2; // bridges counter clockwise

    private static int i9 = 2; // initial state of skb1 clockwise
    private static int i10 = 2; // initial state of skb2 counter clockwise

    private static int[] prismRotateCount = new int[]{i1,i2,i3,i4}; // rotate count

    private static int threeWayRotateCount_a = i5; // threeWay rotateCount
    private static int threeWayRotateCount_b = i6;

    private static int bridgeRotateCount_a = i7; // bridges
    private static int bridgeRotateCount_b = i8;

    private static int skbRotateCount_a = i9; // skb rotate count
    private static int skbRotateCount_b = i10;

    private int rating = 3; // rating count

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_b);

        currentPlayer = Player.getInstance(); // set current player
        currentPlayer.setCurrentLevel(LEVEL_ID);
        currentPlayer.setPlayerScore(playerScore);

        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein); // fadeIn initialization
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout); // fadeOut initialization

        playerName = findViewById(R.id.txtView_playerName);
        playerName.setText(currentPlayer.getPlayerName()); // set player name

        // set value for prisms
        imgView1 = findViewById(R.id.imgView_prism_b1);
        imgView2 = findViewById(R.id.imgView_prism_b2);
        imgView3 = findViewById(R.id.imgView_prism_b3);
        imgView4 = findViewById(R.id.imgView_prism_b4);

        imgView5 = findViewById(R.id.imgView_skb_b1); // set value for skb1
        imgView6 = findViewById(R.id.imgView_skb_b2); // set value for skb2

        imgView7 = findViewById(R.id.imgView_threeway_b1); // set value for threeWay1
        imgView8 = findViewById(R.id.imgView_threeway_b2); // set value for threeWay2

        imgView9 = findViewById(R.id.imgView_bridge_b1); // set value for bridge1
        imgView10 = findViewById(R.id.imgView_bridge_b2); // set value for bridge2

        imgView11 = findViewById(R.id.imgView_planetx_b); // set value for planetX
        imgView12 = findViewById(R.id.imgView_jupiter_b); // set value for jupiter
        imgView13 = findViewById(R.id.imgView_venus_b); // set value for venus

        // set value for light beams vertical
        imgView14 = findViewById(R.id.imgView_lightbeam_b_v1);
        imgView15 = findViewById(R.id.imgView_lightbeam_b_v2);
        imgView16 = findViewById(R.id.imgView_lightbeam_b_v3);
        imgView17 = findViewById(R.id.imgView_lightbeam_b_v4);
        imgView18 = findViewById(R.id.imgView_lightbeam_b_v5);
        imgView19 = findViewById(R.id.imgView_lightbeam_b_v6);
        imgView20 = findViewById(R.id.imgView_lightbeam_b_v7);
        imgView21 = findViewById(R.id.imgView_lightbeam_b_v8);
        imgView22 = findViewById(R.id.imgView_lightbeam_b_v9);
        imgView23 = findViewById(R.id.imgView_lightbeam_b_v10);
        imgView24 = findViewById(R.id.imgView_lightbeam_b_v11);

        // set value for light beams horizontal
        imgView25 = findViewById(R.id.imgView_lightbeam_b_h1);
        imgView26 = findViewById(R.id.imgView_lightbeam_b_h2);
        imgView27 = findViewById(R.id.imgView_lightbeam_b_h3);
        imgView28 = findViewById(R.id.imgView_lightbeam_b_h4);
        imgView29 = findViewById(R.id.imgView_lightbeam_b_h5);
        imgView30 = findViewById(R.id.imgView_lightbeam_b_h6);
        imgView31 = findViewById(R.id.imgView_lightbeam_b_h7);
        imgView32 = findViewById(R.id.imgView_lightbeam_b_h8);
        imgView33 = findViewById(R.id.imgView_lightbeam_b_h9);

        // hide light beams
        imgView14.setVisibility(View.INVISIBLE);
        imgView15.setVisibility(View.INVISIBLE);
        imgView16.setVisibility(View.INVISIBLE);
        imgView17.setVisibility(View.INVISIBLE);
        imgView18.setVisibility(View.INVISIBLE);
        imgView19.setVisibility(View.INVISIBLE);
        imgView20.setVisibility(View.INVISIBLE);
        imgView21.setVisibility(View.INVISIBLE);
        imgView22.setVisibility(View.INVISIBLE);
        imgView23.setVisibility(View.INVISIBLE);
        imgView24.setVisibility(View.INVISIBLE);
        imgView25.setVisibility(View.INVISIBLE);
        imgView26.setVisibility(View.INVISIBLE);
        imgView27.setVisibility(View.INVISIBLE);
        imgView28.setVisibility(View.INVISIBLE);
        imgView29.setVisibility(View.INVISIBLE);
        imgView30.setVisibility(View.INVISIBLE);
        imgView31.setVisibility(View.INVISIBLE);
        imgView32.setVisibility(View.INVISIBLE);
        imgView33.setVisibility(View.INVISIBLE);

        btn_blast = findViewById(R.id.btn_blast_b); // set blast button

        btn_nextLevel = findViewById(R.id.btn_nextLevel_b); // set next level button and hide it
        btn_nextLevel.setVisibility(View.INVISIBLE);

        // set rating stars
        imgView34 = findViewById(R.id.imgView_rating_A);
        imgView35 = findViewById(R.id.imgView_rating_B);
        imgView36 = findViewById(R.id.imgView_rating_C);

        // rotate the planetX
        rotate = AnimationUtils.loadAnimation(GameActivity_B.this, R.anim.rotate_imsu);
        rotate.setFillAfter(true);
        imgView11.startAnimation(rotate);

        // rotate the jupiter
        rotate = AnimationUtils.loadAnimation(GameActivity_B.this, R.anim.rotate_imsu);
        rotate.setFillAfter(true);
        imgView12.startAnimation(rotate);

        // rotate the venus
        rotate = AnimationUtils.loadAnimation(GameActivity_B.this, R.anim.rotate_imsu);
        rotate.setFillAfter(true);
        imgView13.startAnimation(rotate);

        animateX(imgView5, animFadeIn); // show skb1
        animateX(imgView6, animFadeIn); // show skb2

        // skb1 on click listener
        imgView5.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_skb), getResources().getString(R.string.clicked_skb));

            if(imgView14.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView14};
                animateY(imgsOff, animFadeOut);

                imgView14.setVisibility(View.INVISIBLE);
            }
            if(imgView25.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView25};
                animateY(imgsOff, animFadeOut);

                imgView25.setVisibility(View.INVISIBLE);
            }

            if(imgView16.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView16};
                animateY(imgsOff, animFadeOut);

                imgView16.setVisibility(View.INVISIBLE);
            }

            if(imgView26.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView26};
                animateY(imgsOff, animFadeOut);

                imgView26.setVisibility(View.INVISIBLE);
            }

            skbRotateCount_a++; // increases rotate count
            Prism.rotateClockWise(imgView5); // call to rotate the skb1
        });

        // skb1 on click listener
        imgView6.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_skb), getResources().getString(R.string.clicked_skb));

            if(imgView22.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView22};
                animateY(imgsOff, animFadeOut);

                imgView22.setVisibility(View.INVISIBLE);
            }
            if(imgView24.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView24};
                animateY(imgsOff, animFadeOut);

                imgView24.setVisibility(View.INVISIBLE);
            }
            if(imgView31.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView31};
                animateY(imgsOff, animFadeOut);

                imgView31.setVisibility(View.INVISIBLE);
            }
            if(imgView32.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView32};
                animateY(imgsOff, animFadeOut);

                imgView32.setVisibility(View.INVISIBLE);
            }

            skbRotateCount_b++; // increases rotate count
            Prism.rotateCounterClockWise(imgView6); // call to rotate the skb2
        });

        // prisms on click listener
        imgView1.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[0]++; // increases rotate count
            Prism.rotateClockWise(imgView1); // call to rotate the prism
        });

        imgView2.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[1]++;
            Prism.rotateCounterClockWise(imgView2);
        });

        imgView3.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[2]++;
            Prism.rotateClockWise(imgView3);
        });

        imgView4.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[3]++;
            Prism.rotateCounterClockWise(imgView4);
        });

        //  threeWays
        imgView7.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_threeway),getResources().getString(R.string.clicked_threeway));
            threeWayRotateCount_a++;
            Prism.rotateClockWise(imgView7);
        });

        imgView8.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_threeway),getResources().getString(R.string.clicked_threeway));
            threeWayRotateCount_b++;
            Prism.rotateClockWise(imgView8);
        });

        // bridges
        imgView9.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_bridge),getResources().getString(R.string.clicked_bridge));
            bridgeRotateCount_a++;
            Prism.rotateCounterClockWise(imgView9);
        });

        imgView10.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_bridge),getResources().getString(R.string.clicked_bridge));
            bridgeRotateCount_b++;
            Prism.rotateCounterClockWise(imgView10);
        });

        // when blasting checks if the user aligned all prisms correctly
        btn_blast.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_blast), getResources().getString(R.string.clicked_blast));

            int winFlag = 0; // set win to 0

            int q0 = skbRotateCount_a; // get skb1 rotate count
            int q1 = skbRotateCount_b; // get skb2 rotate count

            int r0 = threeWayRotateCount_a; // get threeWay1 rotate count
            int r1 = threeWayRotateCount_b; // get threeWay1 rotate count

            int s0 = bridgeRotateCount_a; // get bridge1 rotate count
            int s1 = bridgeRotateCount_b; // get bridge2 rotate count

            int p1 = prismRotateCount[0]; // rotate counts of satellites
            int p2 = prismRotateCount[1];
            int p3 = prismRotateCount[2];
            int p4 = prismRotateCount[3];

            // checking part
            if(alignmentCheck(skbRotateCount_a)) {
                if(alignmentCheck(skbRotateCount_b)) {
                    if(alignmentCheck(threeWayRotateCount_a)) {
                        if(alignmentCheck(threeWayRotateCount_b)) {
                            if(alignmentCheck(bridgeRotateCount_a)) {
                                if(alignmentCheck(bridgeRotateCount_b)) {
                                    // check the alignment parts of satellites
                                    if(alignmentCheck(p1)) {
                                        if(alignmentCheck(p2)) {
                                            if(alignmentCheck(p3)) {
                                                if (alignmentCheck(p4)) {

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }



        });
    }

    // action when back hw button pressed
    @Override
    public void onBackPressed()
    {
        ft = getFragmentManager().beginTransaction();
        String tag_A = getResources().getString(R.string.fragment_dialog);
        Fragment prev = getFragmentManager().findFragmentByTag(tag_A);
        if(prev != null) {
            ft.remove(prev);
        }

        ft.addToBackStack(null);

        DialogFragment dialogFragment = new PauseGameActivity();
        dialogFragment.show(ft, tag_A);
    }

    // hide blast button
    public void hideBlastButton(Button btn) {
        animateZ(btn, animFadeOut);
        btn.setVisibility(View.INVISIBLE);
    }

    // button animator
    public void animateZ(Button btn, Animation anim) {
        anim.reset();
        btn.clearAnimation();
        btn.startAnimation(anim);
    }

    // beam animator
    public void animateY(final ImageView[] imgs, final Animation anim) {
        for(ImageView img:imgs) {
            animateX(img, anim);
        }
    }

    // alignment checker
    public boolean alignmentCheck(int countState) {
        return countState%4 == 0;
    }

    // fading Animations
    public void animateX(ImageView iv, Animation anim) {
        anim.reset();
        iv.clearAnimation();
        iv.startAnimation(anim);
    }

    public static void setPlayerScore(int playerScore) {
        GameActivity_C.playerScore = playerScore;
    }

    public static int getPlayerScore() {
        return playerScore;
    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

}
