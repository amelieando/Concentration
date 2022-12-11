package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    private Button playBtn;
    private Button hsBtn;
    private Switch switch1;
    private boolean IsAudioOn;
    MediaPlayer music = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView amogUs = (ImageView) findViewById(R.id.amog);
        playBtn = (Button) findViewById(R.id.playBtn);
        hsBtn = (Button) findViewById(R.id.hsBtn);
        switch1 = (Switch) findViewById(R.id.switch1);
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

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioManager amanager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

                if(IsAudioOn){
                    IsAudioOn = false;
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, false); // for unmute

                }else{
                    IsAudioOn = true;
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);  //for mute
                }
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
        }, 4000);

        //Intent intent = new Intent(this, cGame.class);
        //startActivity(intent);
    }

    public void openActivity3() {
            Intent intent = new Intent(this, Highscore.class);
            startActivity(intent);
    }

}