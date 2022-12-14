package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.os.Handler;
import android.widget.TextView;

import java.util.Random;

public class game2x5 extends AppCompatActivity implements View.OnClickListener {

    private int numberOfElements;
    private int score;
    private MemoryButton[] buttons;
    private int nullcount;

    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;

    TextView pScore;

    private MemoryButton selectedButton1;
    private MemoryButton selectedButton2;

    private Button saveBtn;
    private EditText et;
    SharedPreferences sharedPreferences;

    private boolean isBusy = false;
    private int getScore(){
        return score;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2x5);

        saveBtn = (Button) findViewById(R.id.saveButton);
        et = (EditText) findViewById(R.id.enterName);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        GridLayout gridLayout = (GridLayout) findViewById(R.id.Game2x5);

        int numColumns = gridLayout.getColumnCount();
        int numRows = gridLayout.getRowCount();
        score = 0;
        numberOfElements = numColumns * numRows;

        pScore = (TextView) findViewById(R.id.playerScore);
        pScore.setText("Score: " + getScore());

        buttons = new MemoryButton[numberOfElements];

        buttonGraphics = new int[(numberOfElements / 2)+1];

        buttonGraphics[0] = R.drawable.among_us_batman;
        buttonGraphics[1] = R.drawable.among_us_black_hat_blue;
        buttonGraphics[2] = R.drawable.among_us_doctor_brown;
        buttonGraphics[3] = R.drawable.among_us_halo;
        buttonGraphics[4] = R.drawable.among_us_picture_blue_6;

        buttonGraphicLocations = new int[numberOfElements];

        shuffleButtonGraphics();

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                MemoryButton tempButton = new MemoryButton(this, r, c, buttonGraphics[buttonGraphicLocations[r * numColumns + c]]);
                tempButton.setId(View.generateViewId());
                tempButton.setOnClickListener(this);
                buttons[r * numColumns + c] = tempButton;
                gridLayout.addView(tempButton);
            }

        }
    }

    protected void shuffleButtonGraphics() {
        Random rand = new Random();

        for(int i = 0; i< numberOfElements; i++){
            buttonGraphicLocations[i] = i % (numberOfElements / 2);
        }

        for(int i = 0; i < numberOfElements; i++){
            int temp = buttonGraphicLocations[i];

            int swapIndex = rand.nextInt(10);

            buttonGraphicLocations[i] = buttonGraphicLocations[swapIndex];

            buttonGraphicLocations[swapIndex] = temp;
        }

    }

    @Override
    public void onClick(View view) {

        if(isBusy)
            return;

        MemoryButton button = (MemoryButton) view;

        if(button.isMatched)
            return;

        if(selectedButton1 == null)
        {
            selectedButton1 = button;
            selectedButton1.flip();
        }

        if(selectedButton1.getId() == button.getId())
        {
            return;
        }

        if(selectedButton1.getFrontDrawableId() == button.getFrontDrawableId())
        {
            button.flip();

            button.setMatched(true);
            selectedButton1.setMatched(true);
            score = score +2;
            //selectedButton1.setEnabled(false);
            //selectedButton2.setEnabled(false);
            pScore.setText("Score: " + getScore());
            nullcount = nullcount +2;
            selectedButton1 = null;
            if (nullcount == 10){
                saveBtn.setVisibility(View.VISIBLE);
                et.setVisibility(View.VISIBLE);
            }

            return;
        }

        else
        {
            selectedButton2 = button;
            selectedButton2.flip();
            isBusy = true;
            if (score > 0){
                score = score -1;
                pScore.setText("Score: " + getScore());
            }

            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    selectedButton2.flip();
                    selectedButton1.flip();
                    selectedButton1 = null;
                    selectedButton2 = null;
                    isBusy = false;
                }
            }, 500);
        }

    }
    public void openActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openActivity2(){
        EditText editText1 = (EditText) findViewById(R.id.enterName);
        TextView sResult = (TextView) findViewById(R.id.playerScore);

        sharedPreferences = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", editText1.getText().toString());
        editor.putString("Score", sResult.getText().toString());
        editor.apply();

        Intent intent = new Intent(getApplicationContext(), Highscore.class);
        startActivity(intent);
    }
}