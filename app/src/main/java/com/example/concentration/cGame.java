package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class cGame extends AppCompatActivity {
    private Button buttonBack;
    private Button button4x4;
    private Button button4x4_6;
    private Button button4x4_8;
    private Button button4x4_10;
    private Button button4x4_12;
    private Button button4x4_14;
    private Button button4x4_16;
    private Button button4x4_18;
    private Button button4x4_20;
    private Button Backbutton;
    MediaPlayer music = new MediaPlayer();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgame);
        button4x4 = (Button)findViewById(R.id.button4);
        button4x4_6 = (Button)findViewById(R.id.button6);
        button4x4_8 = (Button)findViewById(R.id.button8);
        button4x4_10 = (Button)findViewById(R.id.button10);
        button4x4_12 = (Button)findViewById(R.id.button12);
        button4x4_14 = (Button)findViewById(R.id.button14);
        button4x4_16 = (Button)findViewById(R.id.button16);
        button4x4_18 = (Button)findViewById(R.id.button18);
        button4x4_20 = (Button)findViewById(R.id.button20);
        Backbutton = (Button)findViewById(R.id.buttonBack);

        button4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button4x4.setVisibility(View.GONE);
                button4x4_6.setVisibility(View.GONE);
                button4x4_8.setVisibility(View.GONE);
                button4x4_10.setVisibility(View.GONE);
                button4x4_12.setVisibility(View.GONE);
                button4x4_14.setVisibility(View.GONE);
                button4x4_16.setVisibility(View.GONE);
                button4x4_18.setVisibility(View.GONE);
                button4x4_20.setVisibility(View.GONE);
                Backbutton.setVisibility(View.GONE);
                openActivity2();
                music.stop();
            }
        });

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivity1();
                music.stop();
            }
        });
        music = MediaPlayer.create(cGame.this, R.raw.music);
        music.start();
    }

    public void openActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openActivity2() {
        Intent intent = new Intent(this, game2x2.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this, Highscore.class);
        startActivity(intent);
    }
    public void openActivity4() {
        Intent intent = new Intent(this, test.class);
        startActivity(intent);
    }
}