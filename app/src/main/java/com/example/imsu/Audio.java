package com.example.imsu;

import android.content.Context;
import android.media.MediaPlayer;

public class Audio {
    private static MediaPlayer mediaPlayer;

    public static MediaPlayer setMediaPlayer(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.main_menu_theme_imsu);
        return mediaPlayer;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

}
