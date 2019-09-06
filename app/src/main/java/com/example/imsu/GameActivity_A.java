package com.example.imsu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity_A extends AppCompatActivity implements GameActivity {
    // initial states of prisms
    private static int i1 = 2;
    private static int i2 = 4;
    private static int i3 = 2;

    // rotate count
    private static int[] prismRotateCount = new int[]{i1,i2,i3};

    // rating count
    private int rating = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // declare fade in
        final Animation animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        // declare fade out
        final Animation animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        // game views
        final ImageView imgView1,imgView2,imgView3,imgView4_earth,imgView5_skb,imgView6_lb1,imgView7_lb2,imgView8_lb3,imgView9_lb4,imgView10_ratingA,imgView11_ratingB,imgView12_ratingC;
        final TextView textView_playerName;
        final Button btn_blast;

        // set current player
        Player currentPlayer = Player.getInstance();

        // set player name
        textView_playerName = findViewById(R.id.txtView_playerName);
        textView_playerName.setText(currentPlayer.getPlayerName());

        // set value for prisms
        imgView1 = findViewById(R.id.imgView_prism_1);
        imgView2 = findViewById(R.id.imgView_prism_2);
        imgView3 = findViewById(R.id.imgView_prism_3);

        // set value for earth
        imgView4_earth = findViewById(R.id.imgView_earth);

        // set value for skb
        imgView5_skb = findViewById(R.id.imgView_skb);

        // set value for light beams
        imgView6_lb1 = findViewById(R.id.imgView_lightbeam_h1);
        imgView7_lb2 = findViewById(R.id.imgView_lightbeam_v1);
        imgView8_lb3 = findViewById(R.id.imgView_lightbeam_h2);
        imgView9_lb4 = findViewById(R.id.imgView_lightbeam_v2);

        // hide light beams
        imgView6_lb1.setVisibility(View.INVISIBLE);
        imgView7_lb2.setVisibility(View.INVISIBLE);
        imgView8_lb3.setVisibility(View.INVISIBLE);
        imgView9_lb4.setVisibility(View.INVISIBLE);

        // set blast button
        btn_blast = findViewById(R.id.btn_blast);

        // set rating stars
        imgView10_ratingA = findViewById(R.id.imgView_rating_A);
        imgView11_ratingB = findViewById(R.id.imgView_rating_B);
        imgView12_ratingC = findViewById(R.id.imgView_rating_C);

        // rotate the earth
        Animation rotate = AnimationUtils.loadAnimation(GameActivity_A.this, R.anim.rotate_imsu);
        rotate.setFillAfter(true);
        imgView4_earth.startAnimation(rotate);

        // show skb
        animateX(imgView5_skb, animFadeIn);

        // prism 1 on click listener
        imgView1.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.clicked_prism),getResources().getString(R.string.clicked_prism));

            // increases rotate count
            prismRotateCount[0]++;

            // call to rotate the prism
            Prism.rotateClockWise(imgView1);
        });

        // prism 2 on click listener
        imgView2.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.clicked_prism),getResources().getString(R.string.clicked_prism));

            // increases rotate count
            prismRotateCount[1]++;

            // call to rotate the prism
            Prism.rotateCounterClockWise(imgView2);
        });

        // prism 3 on click listener
        imgView3.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.clicked_prism),getResources().getString(R.string.clicked_prism));

            // increases rotate count
            prismRotateCount[2]++;

            // call to rotate the prism
            Prism.rotateClockWise(imgView3);
        });

        // when blasting checks if the user aligned all prisms correctly
        btn_blast.setOnClickListener(new View.OnClickListener() {
            int winFlag = 0;

            @Override
            public void onClick(View view) {
                Log.i(getResources().getString(R.string.clicked_blast),getResources().getString(R.string.clicked_blast));

                int p1 = prismRotateCount[0];
                int p2 = prismRotateCount[1];
                int p3 = prismRotateCount[2];

                // checking part
                if(alignmentCheck(p1,i1)) {
                    if(alignmentCheck(p2,i2)) {
                        if(alignmentCheck(p3,i3)) {
                            System.out.println(getResources().getString(R.string.level_completed));

                            ImageView[] imgs = {imgView6_lb1,imgView7_lb2,imgView8_lb3,imgView9_lb4};
                            animateY(imgs, animFadeIn);
                                try {
                                    animateX(imgView4_earth, animFadeOut);
                                    Thread.sleep(250);
                                    imgView4_earth.setImageResource(R.drawable.imsu_blast_earth_2);
                                    animateX(imgView4_earth, animFadeIn);
                                }
                                catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            // hide light beams
                            animateX(imgView6_lb1, animFadeOut);
                            animateX(imgView7_lb2, animFadeOut);
                            animateX(imgView8_lb3, animFadeOut);
                            animateX(imgView9_lb4, animFadeOut);

                            // hides the earth
                            imgView4_earth.setVisibility(View.VISIBLE);

                            // shows level completed
                            Toast levelCompletedToast = Toast.makeText(getApplicationContext(), R.string.level_completed, Toast.LENGTH_LONG);
                            levelCompletedToast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 16);
                            levelCompletedToast.show();

                            // sets winning
                            winFlag = 1;

                            // saves level and score

                            // goes to new level
//                            Intent newLevelIntent = new Intent(GameActivity_A.this, GameActivity_B.class);
//                            startActivity(newLevelIntent);

                        }
                    }
                }

                if(winFlag == 0) {
                    rating--;
                    System.out.println(rating);

                    switch (rating) {
                        case 2:
                            imgView10_ratingA.setImageResource(R.drawable.rating_star_imsu_empty);
                            animateX(imgView10_ratingA, animFadeOut);
                            animateX(imgView10_ratingA, animFadeIn);
                            break;
                        case 1:
                            imgView11_ratingB.setImageResource(R.drawable.rating_star_imsu_empty);
                            animateX(imgView11_ratingB, animFadeOut);
                            animateX(imgView11_ratingB, animFadeIn);
                            break;
                        case 0:
                            imgView12_ratingC.setImageResource(R.drawable.rating_star_imsu_empty);
                            animateX(imgView12_ratingC, animFadeOut);
                            animateX(imgView12_ratingC, animFadeIn);
                            break;
                    }
                }

                if (rating == 0 || rating < 0) {
                    System.out.println(getResources().getString(R.string.level_failed));

                    // shows level failed
                    Toast levelFailedToast = Toast.makeText(getApplicationContext(), R.string.level_failed, Toast.LENGTH_LONG);
                    levelFailedToast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 16);
                    levelFailedToast.show();
                }
            }
        });

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

    // alignment checker
    public boolean alignmentCheck(int countState, int initialState) {
        return countState%4 == 0 || initialState%4 == 0;
    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }
}
