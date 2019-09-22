package com.example.imsu;

import android.app.DialogFragment;
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

public class GameActivity_C extends AppCompatActivity implements GameActivity {
    // level details
    final static int LEVEL_ID = 3;
    final static String LEVEL_NAME = Strings.level3;

    private TextView playerName;
    private Button btn_blast; // blast button
    private Button btn_nextLevel; // next level button
    private ImageView imgView1,imgView2,imgView3,imgView4,imgView5,imgView6; // prisms
    private ImageView imgView7; // skb
    private ImageView imgView8; // sun
    private ImageView imgView9,imgView10,imgView11,imgView12,imgView13; // light beams vertical
    private ImageView imgView14,imgView15,imgView16,imgView17,imgView18; // light beams horizontal
    private ImageView imgView19,imgView20,imgView21; // rating stars

    static Player currentPlayer;
    static int playerScore = 30000; // player score

    Animation animFadeIn,animFadeOut,rotate; // animation class variables

    Toast levelToast; // toast declaration

    FragmentTransaction ft; // FragmentTransaction declaration

    // initial states of prisms
    private static int i1 = 3; // clockwise
    private static int i2 = 2; // clockwise
    private static int i3 = 2; // counter clockwise
    private static int i4 = 2; // counter clockwise
    private static int i5 = 3; // clockwise
    private static int i6 = 3; // counter clockwise

    private static int i7 = 2; // initial state of skb clockwise

    private static int[] prismRotateCount = new int[]{i1,i2,i3,i4,i5,i6}; // rotate count
    private static int skbRotateCount = i7;

    private int rating = 3; // rating count

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_c);

        currentPlayer = Player.getInstance(); // set current player
        currentPlayer.setCurrentLevel(LEVEL_ID);
        currentPlayer.setPlayerScore(playerScore);

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

        btn_nextLevel = findViewById(R.id.btn_nextLevel_c); // set next level button and hide it
        btn_nextLevel.setVisibility(View.INVISIBLE);

        // set rating stars
        imgView19 = findViewById(R.id.imgView_rating_A);
        imgView20 = findViewById(R.id.imgView_rating_B);
        imgView21 = findViewById(R.id.imgView_rating_C);

        // rotate the sun
        rotate = AnimationUtils.loadAnimation(GameActivity_C.this, R.anim.rotate_imsu);
        rotate.setFillAfter(true);
        imgView8.startAnimation(rotate);

        animateX(imgView7, animFadeIn); // show skb

        // skb on click listener
        imgView7.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_skb),getResources().getString(R.string.clicked_skb));

            if(imgView16.getVisibility() == View.VISIBLE && imgView18.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView16,imgView18};
                animateY(imgsOff, animFadeOut);

                imgView16.setVisibility(View.INVISIBLE);
                imgView18.setVisibility(View.INVISIBLE);
            }
            else if(imgView11.getVisibility() == View.VISIBLE && imgView13.getVisibility() == View.VISIBLE) {
                ImageView[] imgsOff = {imgView16,imgView18};
                animateY(imgsOff, animFadeOut);

                imgView11.setVisibility(View.INVISIBLE);
                imgView11.setVisibility(View.INVISIBLE);
            }

            skbRotateCount++; // increases rotate count
            Prism.rotateClockWise(imgView7); // call to rotate the skb
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

        imgView5.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[4]++;
            Prism.rotateClockWise(imgView5);
        });

        imgView6.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_view_prism),getResources().getString(R.string.clicked_prism));
            prismRotateCount[5]++;
            Prism.rotateCounterClockWise(imgView6);
        });

        // when blasting checks if the user aligned all prisms correctly
        btn_blast.setOnClickListener(view -> {
            Log.i(getResources().getString(R.string.log_clicked_blast),getResources().getString(R.string.clicked_blast));

            int winFlag = 0; // set win to 0

            int q0 = skbRotateCount; // get skb rotate count

            int p1 = prismRotateCount[0]; // rotate counts of satellites
            int p2 = prismRotateCount[1];
            int p3 = prismRotateCount[2];
            int p4 = prismRotateCount[3];
            int p5 = prismRotateCount[4];
            int p6 = prismRotateCount[5];

            // checking part
            if(alignmentCheck(skbRotateCount))  {
                // check the alignment parts of satellites
                if(alignmentCheck(p1))  {
                    if(alignmentCheck(p2))  {
                        if(alignmentCheck(p3))  {
                            if(alignmentCheck(p4))  {
                                if(alignmentCheck(p5))  {
                                    if(alignmentCheck(p6))  {
                                        if(imgView16.getVisibility() == View.VISIBLE && imgView18.getVisibility() == View.VISIBLE) {
                                            ImageView[] imgsOff = {imgView16,imgView18};
                                            animateY(imgsOff, animFadeOut);

                                            imgView16.setVisibility(View.INVISIBLE);
                                            imgView18.setVisibility(View.INVISIBLE);
                                        }

                                        imgView11.setVisibility(View.VISIBLE);
                                        imgView13.setVisibility(View.VISIBLE);

                                        ImageView[] imgsOn = {imgView11,imgView13};
                                        animateY(imgsOn, animFadeIn);

                                        System.out.println(getResources().getString(R.string.level_completed));

                                        ImageView[] imgs = {imgView9,imgView10,imgView11,imgView12,imgView13,imgView14,imgView15,imgView17};
                                        animateY(imgs, animFadeIn);

                                        try {
                                            Thread.sleep(1000);
                                            animateX(imgView8, animFadeOut);
                                            imgView8.setImageResource(R.drawable.imsu_blast_earth_2);
                                            animateX(imgView8, animFadeIn);
                                        }
                                        catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }

                                        animateY(imgs, animFadeOut); // hides light beams

                                        imgView9.setVisibility(View.INVISIBLE); // hide light beams
                                        imgView10.setVisibility(View.INVISIBLE);
                                        imgView11.setVisibility(View.INVISIBLE);
                                        imgView12.setVisibility(View.INVISIBLE);
                                        imgView13.setVisibility(View.INVISIBLE);
                                        imgView14.setVisibility(View.INVISIBLE);
                                        imgView15.setVisibility(View.INVISIBLE);
                                        imgView16.setVisibility(View.INVISIBLE);
                                        imgView17.setVisibility(View.INVISIBLE);
                                        imgView18.setVisibility(View.INVISIBLE);

                                        imgView8.setVisibility(View.VISIBLE); // show bad earth

                                        levelToast = Toast.makeText(getApplicationContext(), R.string.level_completed, Toast.LENGTH_LONG); // shows level completed
                                        levelToast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 16);
                                        levelToast.show();

                                        winFlag = 1; // set win to 1

                                        if(rating == 3)
                                            setPlayerScore(30000);
                                        else if(rating == 2)
                                            setPlayerScore(20000);
                                        else if(rating == 1)
                                            setPlayerScore(10000);

                                        currentPlayer.setLevelScore(getPlayerScore()); // sets player score
                                        currentPlayer.setPlayerScore(getPlayerScore() + playerScore);

                                        btn_nextLevel.setVisibility(View.VISIBLE); // view next level button
                                        animateZ(btn_nextLevel, animFadeIn);

                                        hideBlastButton(btn_blast); // hides the blast button

                                        // set next level onclick button
                                        btn_nextLevel.setOnClickListener(view1 -> {
                                            Intent nextLevelIntent = new Intent(GameActivity_C.this, GameActivity_D.class);
                                            nextLevelIntent.putExtra(Strings.extra_imsu_levelID,GameActivity_C.LEVEL_ID);
                                            nextLevelIntent.putExtra(Strings.extra_imsu_levelName,GameActivity_C.LEVEL_NAME);
                                            nextLevelIntent.putExtra(Strings.extra_imsu_levelScore,GameActivity_C.getPlayerScore());
                                            startActivity(nextLevelIntent);
                                        });
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else {
                if(q0%4 == 2 || q0%4 == 1) {
                    if(imgView11.getVisibility() == View.VISIBLE && imgView13.getVisibility() == View.VISIBLE) {
                        ImageView[] imgsOff = {imgView16,imgView18};
                        animateY(imgsOff, animFadeOut);

                        imgView11.setVisibility(View.INVISIBLE);
                        imgView11.setVisibility(View.INVISIBLE);
                    }

                    imgView16.setVisibility(View.VISIBLE); // make beams visible
                    imgView18.setVisibility(View.VISIBLE);

                    ImageView[] imgs = {imgView16,imgView18};
                    animateY(imgs, animFadeIn);
                }
            }

            // check if won
            if(winFlag == 0) {
                rating--;
                System.out.println(rating);

                switch (rating) {
                    case 2:
                        imgView19.setImageResource(R.drawable.rating_star_imsu_empty);
                        animateX(imgView19, animFadeOut);
                        animateX(imgView19, animFadeIn);
                        break;
                    case 1:
                        imgView20.setImageResource(R.drawable.rating_star_imsu_empty);
                        animateX(imgView20, animFadeOut);
                        animateX(imgView20, animFadeIn);
                        break;
                    case 0:
                        imgView21.setImageResource(R.drawable.rating_star_imsu_empty);
                        animateX(imgView21, animFadeOut);
                        animateX(imgView21, animFadeIn);
                        break;
                }
            }

            if (rating == 0 || rating < 0) {
                System.out.println(getResources().getString(R.string.level_failed));
                setPlayerScore(0); // setScore

                // shows level failed
                levelToast = Toast.makeText(getApplicationContext(), R.string.level_failed, Toast.LENGTH_LONG);
                levelToast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 16);
                levelToast.show();

                hideBlastButton(btn_blast); // hides the blast button
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
