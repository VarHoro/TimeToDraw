package com.example.suslik.activities;

import android.widget.ImageView;

import com.example.suslik.generation.GIdeas;
import com.example.suslik.R;

public class ActIdeas extends SCGenActivity {
@Override
    public void setGenAndBG(){
        generator = new GIdeas(this);
        bg = (ImageView) findViewById(R.id.bg);
        bg.setBackgroundResource(R.drawable.back_ideas);
        diff = 22;
    }
}
