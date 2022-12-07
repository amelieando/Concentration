package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button playBtn;
    private Button hsBtn;
    private Button button4x4;
    MediaPlayer music = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView amogUs = (ImageView) findViewById(R.id.amog);
        playBtn = (Button) findViewById(R.id.playBtn);
        hsBtn = (Button) findViewById(R.id.hsBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playBtn.setVisibility(View.GONE);
                hsBtn.setVisibility(View.GONE);
                amogUs.setVisibility(View.VISIBLE);
                openActivity2();
                music.stop();
            }
        });

        hsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
                music.stop();
            }
        });

        music = MediaPlayer.create(MainActivity.this, R.raw.music);
        music.start();
    }

    public void openActivity2() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, cGame.class));
            }
        }, 5000);
        button4x4 = (Button)findViewById(R.id.button4);

        button4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, game4x4.class);
                startActivity(intent);
            }
        });

        //Intent intent = new Intent(this, cGame.class);
        //startActivity(intent);
    }

    public void openActivity3() {
            Intent intent = new Intent(this, Highscore.class);
            startActivity(intent);
    }
}