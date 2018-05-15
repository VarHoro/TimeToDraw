package com.example.suslik.generation;

import android.content.Context;

import com.example.suslik.activities.IGeneration;
import com.example.suslik.R;

import java.util.Random;

public class GPractice extends GWords implements IGeneration {

    public GPractice(Context current){
        this.current = current;
    }

    @Override
    public String getResult(int diff){
        Random rn = new Random();
        String res = getRawString(R.raw.practice, rn.nextInt(getLength(R.raw.practice)));
        return res.substring(0,1).toUpperCase() + res.substring(1);
    }
}
