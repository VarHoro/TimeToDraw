package com.example.suslik.activities;

import android.widget.ImageView;

import com.example.suslik.generation.GPuzzle;
import com.example.suslik.R;

public class ActPuzzle extends SCGenActivity {

    @Override
    public void setGenAndBG(){
        generator = new GPuzzle(this);
        bg = (ImageView) findViewById(R.id.bg);
        bg.setBackgroundResource(R.drawable.back_puzzle);
        diff = 2;
    }
}
