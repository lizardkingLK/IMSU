package com.example.imsu;

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

public class GameActivity_D extends AppCompatActivity implements GameActivity {
    // level details
    final static int LEVEL_ID = 4;
    final static String LEVEL_NAME = Strings.level4;

    private TextView playerName;
    private Button btn_blast; // blast button
    private Button btn_nextLevel; // next level button
    private ImageView imgView1,imgView2,imgView3,imgView4; // prisms
    private ImageView imgView5; // skb
    private ImageView imgView6; // threeWay
    private ImageView imgView7; // mars
    private ImageView imgView8; // moon
    private ImageView imgView9,imgView10,imgView11,imgView12,imgView13; // light beams vertical
    private ImageView imgView14,imgView15,imgView16,imgView17,imgView18,imgView19; // light beams horizontal
    private ImageView imgView20,imgView21,imgView22; // rating stars

    static Player currentPlayer;
    static int playerScore = 30000; // player score

    Animation animFadeIn,animFadeOut,rotate; // animation class variables

    Toast levelToast; // toast declaration

    FragmentTransaction ft; // FragmentTransaction declaration

    // initial states of prisms
    private static int i1 = 2; // clockwise
    private static int i2 = 2; // clockwise
    private static int i3 = 3; // counter clockwise
    private static int i4 = 2; // counter clockwise

    private static int i5 = 2; // skb clockwise
    private static int i6 = 3; // threeWay counter clockwise

    private int rating = 3; // rating count

    private static int[] prismRotateCount = new int[]{i1,i2,i3,i4}; // rotate count
    private static int skbRotateCount = i5; // skb rotate count
    private static int threeWayRotateCount = i6; // threeWay rotate count

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_d);

        currentPlayer = Player.getInstance(); // set current player
        currentPlayer.setCurrentLevel(LEVEL_ID);
        currentPlayer.setPlayerScore(playerScore);

        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein); // fadeIn initialization
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout); // fadeOut initialization

        playerName = findViewById(R.id.txtView_playerName_d);
        playerName.setText(currentPlayer.getPlayerName()); // set player name

        // set value for prisms
        imgView1 = findViewById(R.id.imgView_prism_d1);
        imgView2 = findViewById(R.id.imgView_prism_d2);
        imgView3 = findViewById(R.id.imgView_prism_d3);
        imgView4 = findViewById(R.id.imgView_prism_d4);

        imgView5 = findViewById(R.id.imgView_skb_d); // set value for skb
        imgView6 = findViewById(R.id.imgView_threeway_d); // set value for threeWay

        // set value for light beams vertical
        imgView9 = findViewById(R.id.imgView_lightbeam_v1_d);
        imgView10 = findViewById(R.id.imgView_lightbeam_v2_d);
        imgView11 = findViewById(R.id.imgView_lightbeam_v3_d);
        imgView12 = findViewById(R.id.imgView_lightbeam_v4_d);
        imgView13 = findViewById(R.id.imgView_lightbeam_v5_d);

        // set value for light beams horizontal
        imgView14 = findViewById(R.id.imgView_lightbeam_h1_d);
        imgView15 = findViewById(R.id.imgView_lightbeam_h2_d);
        imgView16 = findViewById(R.id.imgView_lightbeam_h3_d);
        imgView17 = findViewById(R.id.imgView_lightbeam_h4_d);
        imgView18 = findViewById(R.id.imgView_lightbeam_h5_d);
        imgView19 = findViewById(R.id.imgView_lightbeam_h6_d);

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
        imgView19.setVisibility(View.INVISIBLE);

        btn_blast = findViewById(R.id.btn_blast_d); // set blast button

        btn_nextLevel = findViewById(R.id.btn_nextLevel_d); // set next level button and hide it
        btn_nextLevel.setVisibility(View.INVISIBLE);

        // set rating stars
        imgView20 = findViewById(R.id.imgView_rating_A);
        imgView21 = findViewById(R.id.imgView_rating_B);
        imgView22 = findViewById(R.id.imgView_rating_C);

        // rotate the mars
        rotate = AnimationUtils.loadAnimation(GameActivity_D.this, R.anim.rotate_imsu);
        rotate.setFillAfter(true);
        imgView7.startAnimation(rotate);

        // rotate the moon
        rotate = AnimationUtils.loadAnimation(GameActivity_D.this, R.anim.rotate_imsu);
        rotate.setFillAfter(true);
        imgView8.startAnimation(rotate);

        animateX(imgView5, animFadeIn); // show skb

        // prisms on click listener
        imgView1.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[0]++; // increases rotate count
            Prism.rotateClockWise(imgView1); // call to rotate the prism
        });

        imgView2.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[1]++;
            Prism.rotateClockWise(imgView2);
        });

        imgView3.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[2]++;
            Prism.rotateCounterClockWise(imgView3);
        });

        imgView4.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[3]++;
            Prism.rotateCounterClockWise(imgView4);
        });

        // skb on click listener
        imgView5.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_skb),getResources().getString(R.string.clicked_skb));

            if(imgView10.getVisibility() == View.VISIBLE && imgView12.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView10,imgView12};
                animateY(imgsOff, animFadeOut);

                imgView10.setVisibility(View.INVISIBLE);
                imgView12.setVisibility(View.INVISIBLE);
            }
            else if(imgView13.getVisibility() == View.VISIBLE || imgView18.getVisibility() == View.VISIBLE || imgView19.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView13,imgView18,imgView19};
                animateY(imgsOff, animFadeOut);

                imgView13.setVisibility(View.INVISIBLE);
                imgView18.setVisibility(View.INVISIBLE);
                imgView19.setVisibility(View.INVISIBLE);
            }

            skbRotateCount++; // increases rotate count
            Prism.rotateClockWise(imgView5); // call to rotate the skb
        });

        // threeway on click listener
        imgView6.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_threeway),getResources().getString(R.string.clicked_threeway));
            threeWayRotateCount++;
            Prism.rotateCounterClockWise(imgView6);
        });

        // when blasting checks if the user aligned all prisms correctly
        btn_blast.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_blast),getResources().getString(R.string.clicked_blast));

            int winFlag = 0; // set win to 0

            int q0 = skbRotateCount; // get skb rotate count
            int q1 = threeWayRotateCount; // get threeWay rotate count

            int p1 = prismRotateCount[0]; // rotate counts of satellites
            int p2 = prismRotateCount[1];
            int p3 = prismRotateCount[2];
            int p4 = prismRotateCount[3];

            // checking part
            if(alignmentCheck(skbRotateCount))  { // check the alignment parts of skb
                if(alignmentCheck(threeWayRotateCount))  { // check the alignment parts of threeWay
                    if(alignmentCheck(p1))  { // check the alignment parts of satellites
                        if(alignmentCheck(p2))  {
                            if(alignmentCheck(p3)) {
                                if (alignmentCheck(p4)) {
                                    if(imgView10.getVisibility() == View.VISIBLE && imgView12.getVisibility() == View.VISIBLE) {
                                        ImageView[] imgsOff = {imgView10,imgView12};
                                        animateY(imgsOff, animFadeOut);

                                        imgView10.setVisibility(View.INVISIBLE);
                                        imgView12.setVisibility(View.INVISIBLE);
                                    }
                                    else if(imgView13.getVisibility() == View.VISIBLE || imgView18.getVisibility() == View.VISIBLE || imgView19.getVisibility() == View.VISIBLE) {
                                        ImageView[] imgsOff = {imgView13,imgView18,imgView19};
                                        animateY(imgsOff, animFadeOut);

                                        imgView13.setVisibility(View.INVISIBLE);
                                        imgView18.setVisibility(View.INVISIBLE);
                                        imgView19.setVisibility(View.INVISIBLE);
                                    }

                                    imgView10.setVisibility(View.VISIBLE);
                                    imgView12.setVisibility(View.VISIBLE);

                                    ImageView[] imgsOn = {imgView10,imgView12};
                                    animateY(imgsOn, animFadeIn);

                                    System.out.println(getResources().getString(R.string.level_completed));

                                    ImageView[] imgs = {imgView9,imgView10,imgView11,imgView12,imgView13,imgView14,imgView15,imgView17};
                                    animateY(imgs, animFadeIn);

                                    ////
                                }
                            }
                        }
                    }
                }
            }

        });

    }

    // alignment checker
    public boolean alignmentCheck(int countState) {
        if(countState%4 != 0 && countState == threeWayRotateCount) {
            imgView16.setVisibility(View.VISIBLE);
            imgView18.setVisibility(View.VISIBLE);

            ImageView[] imgsOn = {imgView16,imgView18};
            animateY(imgsOn, animFadeIn);
        }

        return countState%4 == 0;
    }

    // fading Animations
    public void animateX(ImageView iv, Animation anim) {
        anim.reset();
        iv.clearAnimation();
        iv.startAnimation(anim);
    }

    // beam animator
    public void animateY(final ImageView[] imgs, final Animation anim) {
        for(ImageView img:imgs) {
            animateX(img, anim);
        }
    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }
}
