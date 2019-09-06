package com.example.imsu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SelectLevelActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_selectlevel);

        Intent newLevelIntent = new Intent(SelectLevelActivity.this, GameActivity_B.class);
        startActivity(newLevelIntent);
    }
}
