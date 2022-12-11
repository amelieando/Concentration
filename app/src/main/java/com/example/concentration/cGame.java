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
                openActivity2();
                music.stop();
            }
        });
        button4x4_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity5();
                music.stop();
            }
        });
        button4x4_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity6();
                music.stop();
            }
        });
        button4x4_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity7();
                music.stop();
            }
        });
        button4x4_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity8();
                music.stop();
            }
        });
        button4x4_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity9();
                music.stop();
            }
        });
        button4x4_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity10();
                music.stop();
            }
        });
        button4x4_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity11();
                music.stop();
            }
        });
        button4x4_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity12();
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
    public void openActivity5() {
        Intent intent = new Intent(this, game2x3.class);
        startActivity(intent);
    }
    public void openActivity6() {
        Intent intent = new Intent(this, game2x4.class);
        startActivity(intent);
    }
    public void openActivity7() {
        Intent intent = new Intent(this, game2x5.class);
        startActivity(intent);
    }
    public void openActivity8() {
        Intent intent = new Intent(this, game2x6.class);
        startActivity(intent);
    }
    public void openActivity9() {
        Intent intent = new Intent(this, game2x7.class);
        startActivity(intent);
    }
    public void openActivity10() {
        Intent intent = new Intent(this, game2x8.class);
        startActivity(intent);
    }
    public void openActivity11() {
        Intent intent = new Intent(this, game2x9.class);
        startActivity(intent);
    }
    public void openActivity12() {
        Intent intent = new Intent(this, game2x10.class);
        startActivity(intent);
    }
}