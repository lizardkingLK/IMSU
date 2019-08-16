package com.example.imsu;

import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Prism {

    public static void rotateClockWise(ImageView imgView) {
        int pivotX = imgView.getWidth()/2;
        int pivotY = imgView.getHeight()/2;

        int mCurrRotation = 0; // takes the place of getRotation()

        float fromRotation = mCurrRotation;
        float toRotation = mCurrRotation += 90;

        final RotateAnimation rotateAnim = new RotateAnimation(
                fromRotation, toRotation, pivotX, pivotY);

        rotateAnim.setDuration(500); // Use 0 ms to rotate instantly
        rotateAnim.setFillAfter(true); // Must be true or the animation will reset

        imgView.startAnimation(rotateAnim);

        imgView.setRotation(imgView.getRotation() + 90);
    }

    public static void rotateCounterClockWise(ImageView imgView) {
        int pivotX = imgView.getWidth()/2;
        int pivotY = imgView.getHeight()/2;

        int mCurrRotation = 0; // takes the place of getRotation()

        float fromRotation = mCurrRotation;
        float toRotation = mCurrRotation -= 90;

        final RotateAnimation rotateAnim = new RotateAnimation(
                fromRotation, toRotation, pivotX, pivotY);

        rotateAnim.setDuration(500); // Use 0 ms to rotate instantly
        rotateAnim.setFillAfter(true); // Must be true or the animation will reset

        imgView.startAnimation(rotateAnim);

        imgView.setRotation(imgView.getRotation() - 90);
    }
}
