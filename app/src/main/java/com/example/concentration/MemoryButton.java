package com.example.concentration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatDrawableManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import com.example.concentration.R;

public class MemoryButton extends androidx.appcompat.widget.AppCompatButton {

    public Object isMatched;
    protected int row;
    protected int column;
    protected int frontDrawableId;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;
    protected Drawable front;
    protected Drawable back;

    @SuppressLint("RestrictedApi")
    public MemoryButton(Context context, int r, int c, int frontImageDrawableId)
    {
        super(context);

        row = r;
        column = c;
        frontDrawableId = frontImageDrawableId;

        front = AppCompatDrawableManager.get().getDrawable(context, frontImageDrawableId;)
        back = AppCompatDrawableManager.get().getDrawable(context.R.drawable.dum);

        setBackground(back);

        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(r), GridLayout.spec(c));

        tempParams.width = (int) getResources().getDisplayMetrics().density * 50;
        tempParams.height = (int) getResources().getDisplayMetrics().density * 50;

        setLayoutParams(tempParams);
    }

    public boolean isMatched() {
        return (boolean) isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public int getFrontDrawableId() {
        return frontDrawableId;
    }

    public void flip() {
        if((boolean) isMatched)
            return;

        if(isFlipped)
        {
            setBackground(back);
            isFlipped = false;
        }

        else
        {
            setBackground(front);
            isFlipped = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_button);
    }
}