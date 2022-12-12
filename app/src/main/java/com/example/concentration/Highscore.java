package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Highscore extends AppCompatActivity {
    private Button buttonBackHS;
    MediaPlayer music = new MediaPlayer();
    TextView scoreLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        scoreLabel = (TextView) findViewById(R.id.highScore);

        SharedPreferences result = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        String value = result.getString("Name", "None");
        String value2 = result.getString("Score", "None");
        scoreLabel.setText(value + "    " + value2);

        buttonBackHS = (Button) findViewById(R.id.buttonBackHS);
        buttonBackHS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivity1();
                music.stop();
            }
        });
        music = MediaPlayer.create(Highscore.this, R.raw.music);
        music.start();
    }

    public void openActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}