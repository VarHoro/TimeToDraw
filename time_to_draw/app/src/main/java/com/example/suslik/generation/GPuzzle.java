package com.example.suslik.generation;

import android.content.Context;

import com.example.suslik.activities.IGeneration;
import com.example.suslik.R;

import java.util.Random;

public class GPuzzle extends GWords implements IGeneration {

    public GPuzzle(Context current){
        this.current = current;
    }

    @Override
    public String getResult(int diff){
        Random rn = new Random();

        int n = getLength(R.raw.noun);
        String noun;
        String puzzle = "";

        for (int i = 0; i<diff-1; i++){
            noun = getWordByChase(getRawString(R.raw.noun, rn.nextInt(n)), 0);
            puzzle += "«" + noun + "»  \n + \n ";
        }
        noun = getWordByChase(getRawString(R.raw.noun, rn.nextInt(n)), 0);
        puzzle += "«" + noun + "»";
        return puzzle;
    }
}
