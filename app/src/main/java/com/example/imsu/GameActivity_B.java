package com.example.imsu;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameActivity_B extends View implements GameActivity {
    public GameActivity_B(Context context, @Nullable AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(getResources().getColor(R.color.colorGradientGameDark));

    }



    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }


}
