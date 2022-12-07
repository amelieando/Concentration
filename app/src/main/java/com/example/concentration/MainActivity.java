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
    private Button button4x4_6;
    private Button button4x4_8;
    private Button button4x4_10;
    private Button button4x4_12;
    private Button button4x4_14;
    private Button button4x4_16;
    private Button button4x4_18;
    private Button button4x4_20;
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
        button4x4_6 = (Button)findViewById(R.id.button6);
        button4x4_8 = (Button)findViewById(R.id.button8);
        button4x4_10 = (Button)findViewById(R.id.button10);
        button4x4_12 = (Button)findViewById(R.id.button12);
        button4x4_14 = (Button)findViewById(R.id.button14);
        button4x4_16 = (Button)findViewById(R.id.button16);
        button4x4_18 = (Button)findViewById(R.id.button18);
        button4x4_20 = (Button)findViewById(R.id.button20);

        button4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, game4x4.class);
                startActivity(intent);
                button4x4.setVisibility(View.GONE);
                button4x4_6.setVisibility(View.GONE);
                button4x4_8.setVisibility(View.GONE);
                button4x4_10.setVisibility(View.GONE);
                button4x4_12.setVisibility(View.GONE);
                button4x4_14.setVisibility(View.GONE);
                button4x4_16.setVisibility(View.GONE);
                button4x4_18.setVisibility(View.GONE);
                button4x4_20.setVisibility(View.GONE);
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