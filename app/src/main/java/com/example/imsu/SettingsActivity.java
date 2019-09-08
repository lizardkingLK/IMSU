package com.example.imsu;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Switch;

public class SettingsActivity extends Activity {
    private Switch switchSfx,switchMusic;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switchSfx = findViewById(R.id.switch_sfx);
        switchMusic = findViewById(R.id.switch_music);

        mp = Audio.getMediaPlayer();

        if(mp.isPlaying())
            switchMusic.setChecked(true);

        switchSfx.setChecked(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        switchMusic.setOnCheckedChangeListener((compoundButton, b) -> {
            if(!switchMusic.isChecked()) {
                mp.stop();
                mp = null;
            }
            else {
                mp = Audio.setMediaPlayer(getApplicationContext());
                mp.start();
            }
        });
    }

}
