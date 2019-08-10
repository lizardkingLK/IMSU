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

                // call to rotate the prism
                Prism.rotateClockWise(imgView);
            }
        });
    }
}
