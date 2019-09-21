package com.example.imsu;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
import android.app.DialogFragment;

public class GameActivity_A extends AppCompatActivity implements GameActivity {
    // level details
    final static int LEVEL_ID = 1;
    final static String LEVEL_NAME = Strings.level1;

    // current Player
    static Player currentPlayer;

    // player score
    static int playerScore = 30000;

    // image Views
    ImageView imgView1,imgView2,imgView3,imgView4_earth,imgView5_skb,imgView6_lb1,imgView7_lb2,imgView8_lb3,imgView9_lb4,imgView10_ratingA,imgView11_ratingB,imgView12_ratingC;

    // text Views
    TextView textView_playerName;

    // blast Button
    Button btn_blast;

    // next level button
    Button btn_nextLevel;

    // animation class variables
    Animation animFadeIn,animFadeOut;

    // toast declaration
    Toast levelToast;

    // FragmentTransaction declaration
    FragmentTransaction ft;

    // initial states of prisms
    private static int i1 = 2;
    private static int i2 = 3;
    private static int i3 = 2;

    // rotate count
    private static int[] prismRotateCount = new int[]{i1,i2,i3};

    // rating count
    private int rating = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // set current player
        currentPlayer = Player.getInstance();
        currentPlayer.setCurrentLevel(LEVEL_ID);
        currentPlayer.setPlayerScore(playerScore);

        // declare fadeIn and fadeOut
        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fadeout);

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

        // set next level button and hide it
        btn_nextLevel = findViewById(R.id.btn_nextLevel);
        btn_nextLevel.setVisibility(View.INVISIBLE);

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
                if(alignmentCheck(p1)) {
                    if(alignmentCheck(p2)) {
                        if(alignmentCheck(p3)) {
                            System.out.println(getResources().getString(R.string.level_completed));

                            ImageView[] imgs = {imgView6_lb1,imgView7_lb2,imgView8_lb3,imgView9_lb4};
                            animateY(imgs, animFadeIn);

                            try {
                                Thread.sleep(1000);
                                animateX(imgView4_earth, animFadeOut);
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

                            // show bad earth
                            imgView4_earth.setVisibility(View.VISIBLE);

                            // shows level completed
                            levelToast = Toast.makeText(getApplicationContext(), R.string.level_completed, Toast.LENGTH_LONG);
                            levelToast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 16);
                            levelToast.show();

                            // sets winning
                            winFlag = 1;

                            if(rating == 3)
                                setPlayerScore(30000);
                            else if(rating == 2)
                                setPlayerScore(20000);
                            else if(rating == 1)
                                setPlayerScore(10000);

                            // sets player score
                            currentPlayer.setLevelScore(getPlayerScore());
                            currentPlayer.setPlayerScore(getPlayerScore() + playerScore);

                            // view next level button
                            btn_nextLevel.setVisibility(View.VISIBLE);
                            animateZ(btn_nextLevel, animFadeIn);

                            // hides the blast button
                            hideBlastButton(btn_blast);

                            // set next level onclick button
                            btn_nextLevel.setOnClickListener(view1 -> {
                                Intent nextLevelIntent = new Intent(GameActivity_A.this, GameActivity_C.class);
                                    nextLevelIntent.putExtra(Strings.extra_imsu_levelID,GameActivity_A.LEVEL_ID);
                                    nextLevelIntent.putExtra(Strings.extra_imsu_levelName,GameActivity_A.LEVEL_NAME);
                                    nextLevelIntent.putExtra(Strings.extra_imsu_levelScore,GameActivity_A.getPlayerScore());
                                startActivity(nextLevelIntent);
                            });
                        }
                    }
                }

                // check if won
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
                    // setScore
                    setPlayerScore(0);

                    // shows level failed
                    levelToast = Toast.makeText(getApplicationContext(), R.string.level_failed, Toast.LENGTH_LONG);
                    levelToast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 16);
                    levelToast.show();

                    // hides the blast button
                    hideBlastButton(btn_blast);

                    // retry button
                    //
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

    // button animator
    public void animateZ(Button btn, Animation anim) {
        anim.reset();
        btn.clearAnimation();
        btn.startAnimation(anim);
    }

    // alignment checker
    public boolean alignmentCheck(int countState) {
        return countState%4 == 0;
    }

    public static int getPlayerScore() {
        return playerScore;
    }

    public static void setPlayerScore(int playerScore) {
        GameActivity_A.playerScore = playerScore;
    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }
}


