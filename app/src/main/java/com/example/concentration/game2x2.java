package com.example.concentration;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.GridLayout;
import android.os.Handler;
import android.widget.TextView;

import java.util.Random;

public class game2x2 extends AppCompatActivity implements View.OnClickListener {
    private int numberOfElements;
    private int score;
    private MemoryButton[] buttons;
    private int nullcount;

    TextView pScore;

    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;

    private MemoryButton selectedButton1;
    private MemoryButton selectedButton2;

    private boolean isBusy = false;
    private int getScore(){
        return score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2x2);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.Game2x2);

        int numColumns = gridLayout.getColumnCount();
        int numRows = gridLayout.getRowCount();

        numberOfElements = numColumns * numRows;

        pScore = (TextView) findViewById(R.id.playerScore);
        pScore.setText("Score: " + getScore());

        buttons = new MemoryButton[numberOfElements];

        buttonGraphics = new int[(numberOfElements / 2)];

        buttonGraphics[0] = R.drawable.among_us_batman;
        buttonGraphics[1] = R.drawable.among_us_black_hat_blue;

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

            int swapIndex = rand.nextInt(4);

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
            nullcount = nullcount +2;

            pScore.setText("Score: " + getScore());

            selectedButton1 = null;
            if (nullcount == 4){
                openActivity1();
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
}
