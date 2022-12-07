package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Highscore extends AppCompatActivity {
    private Button buttonBackHS;
    MediaPlayer music = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
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