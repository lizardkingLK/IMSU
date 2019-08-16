package com.example.imsu;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class DrawActivity extends Activity {
    ImageView imgView1,imgView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawactivity);

        imgView1.setImageResource(R.drawable.lightbeam_imsu_horizontal_unit);
//        imgView1.set
    }

    // drawing light beams
    public static void drawLineToRight(int startPointX, int startPointY, int endPointX, int endPointY) {

    }

    public static void drawLineToLeft(int startPointX, int startPointY, int endPointX, int endPointY) {

    }

    public static void drawLineToUp(int startPointX, int startPointY, int endPointX, int endPointY) {

    }

    public static void drawLineToDown(int startPointX, int startPointY, int endPointX, int endPointY) {

    }
}