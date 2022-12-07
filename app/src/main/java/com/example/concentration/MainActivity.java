package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button playBtn;
    private Button hsBtn;

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
            }
        });
    }

    public void openActivity2() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, cGame.class));
            }
        }, 5000);
        //Intent intent = new Intent(this, cGame.class);
        //startActivity(intent);
    }
    
}