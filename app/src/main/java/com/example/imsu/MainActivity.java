package com.example.imsu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        System.out.println("Clicked ScoreBoard");

        // Get the view from activity_main.xml
        setContentView(R.layout.activity_scoreboard);

        // Get the correct button
        button = findViewById(R.id.btn_ScoreBoard);

        // Start ScoreBoardActivity.class
        Intent myIntent = new Intent(MainActivity.this, ScoreBoardActivity.class);
        startActivity(myIntent);
    }
}
