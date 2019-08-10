package com.example.imsu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ImageView imgView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // set value for prism
        imgView = findViewById(R.id.imgView_prism_1);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(getResources().getString(R.string.clicked_prism),getResources().getString(R.string.clicked_prism));

                int pivotX = imgView.getWidth()/2;
                int pivotY = imgView.getHeight()/2;

                int mCurrRotation = 0; // takes the place of getRotation()

                mCurrRotation %= 360;
                float fromRotation = mCurrRotation;
                float toRotation = mCurrRotation += 90;

                final RotateAnimation rotateAnim = new RotateAnimation(
                        fromRotation, toRotation, pivotX, pivotY);

                rotateAnim.setDuration(250); // Use 0 ms to rotate instantly
                rotateAnim.setFillAfter(true); // Must be true or the animation will reset

                imgView.startAnimation(rotateAnim);

                imgView.setRotation(imgView.getRotation() + 90);
            }
        });
    }
}
