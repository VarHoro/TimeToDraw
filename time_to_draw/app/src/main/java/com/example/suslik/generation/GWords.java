package com.example.suslik.generation;

import com.example.suslik.activities.IGeneration;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class GWords implements IGeneration  {
    protected Context current;
    @Override
    public String getResult(int diff){
        return "smth diff've gone wrong";
    }

    protected String getRawString(int resId, int n) //public String readTxtStringId(int resId, int n)
    {
        InputStream inputStream = current.getResources().openRawResource(resId);

        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader buffReader = new BufferedReader(inputReader);
        String line;
        StringBuilder text = new StringBuilder();
        int i =0;
        try {
            while (( line = buffReader.readLine()) != null && i<n) {
                i++;
            }
            text.append(line);
            text.append('\n');
        } catch (IOException e) {
            return null;
        }
        return text.toString();
    }
    protected int getFirstCharToInt(String str) // public int GetFirstCharToInt(String str)
    {
        char c = str.charAt(0);
        return Character.getNumericValue(c);
    }
    protected String getWordByChaseAndGender(String str, int ch, int gen) //public String GetAdj(String str, int cl, int gen){
    {String s = str;
        int sep;
        int i = 0;
        if (ch!=0){
            while (i<ch*3) { //дойти до нужного падежа
                sep = s.indexOf(" ");
                s = s.substring(sep+1);
                i++;
            }
        }
        i = 0;
        if (gen!=0){
            while (i<gen){ //дойти до правильного рода
                sep = s.indexOf(" ");
                s = s.substring(sep+1);
                i++;
            }
        }
        sep = s.indexOf(" ");
        s = s.substring(0, sep);
        return s;
    }
    protected String getWordByChase(String str, int ch)//public String GetNoun(String str, int cl)
    {
        int sep, i = 0;
        boolean f = true;
        String s = str + " ";
        while (i<ch) {
            sep = s.indexOf(" ");
            s = s.substring(sep+1);
            i++;
            f = false;
        }
        sep = s.indexOf(" ");
        if (f){
            return s.substring(1, sep);
        }
        else{
            return s.substring(0, sep);
        }
    }
    protected int getLength(int resId) // public String TxtLength(int resId)
    {
        InputStream inputStream = current.getResources().openRawResource(resId);

        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader buffReader = new BufferedReader(inputReader);
        int i =0;

        try {
            while (buffReader.readLine() != null) {
                i++;
            }
        } catch (IOException e) {
            return Integer.parseInt(null);
        }
        return i;
    }
}
