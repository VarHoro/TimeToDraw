package com.example.suslik.activities;

import android.widget.ImageView;

import com.example.suslik.generation.GPractice;
import com.example.suslik.R;

public class ActPractice extends SCGenActivity {

    @Override
    public void setGenAndBG(){
        generator = new GPractice(this);
        bg = (ImageView) findViewById(R.id.bg);
        bg.setBackgroundResource(R.drawable.back_practice);
        diff = 1;
    }
}
