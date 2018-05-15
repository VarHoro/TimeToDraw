package com.example.suslik.generation;

import android.graphics.Color;
import com.example.suslik.activities.IGenerationColor;
import java.util.Random;

public class GColors implements IGenerationColor {
    private int cdiff;

    @Override
    public String[] getResult(int diff){
        cdiff = diff;
        String color  = newColor();
        return ColorSetGen(diff, color);
    }
    //новый случайный цвет
    private String newColor()
    {
        Random rn = new Random();
        int n = rn.nextInt(256*256*256);
        return String.format("#%06x", n);
    }

    //определение типа сочетания
    private String[] ColorSetGen(Integer op, String mColor)
    {
        int d = op/10;
        String[] colorset = new String[d];
        colorset[0] = mColor;
        switch (op) { //просто рандом
            case 20:
            case 30:
            case 40:
                for (int i=1; i<d; i++){colorset[i] = newColor();}
                return colorset;
            case 21: //контрастные цвета
                colorset[1] = newColorContrast(mColor);
                return colorset;
            case 31: //триада
                colorset[1] = newColorTriple(mColor,1);
                colorset[2] = newColorTriple(mColor,2);
                return colorset;
            case 32: //аналогия
                colorset[1] = newColorAnalogTriple(mColor,1);
                colorset[2] = newColorAnalogTriple(mColor,2);
                return colorset;
            case 41: //тетрада
                colorset[1] = newColorTetra(mColor,1);
                colorset[2] = newColorTetra(mColor,2);
                colorset[3] = newColorTetra(mColor,3);
                return colorset;
            case 42: //аналогия + акцент
                colorset[1] = newColorAnalogAccent(mColor,1);
                colorset[2] = newColorAnalogAccent(mColor,2);
                colorset[3] = newColorAnalogAccent(mColor,3);
                return colorset;
            default:
                colorset[0]="#000000";
                colorset[1]="#000000";
                return colorset;
        }
    }

    //перевод из hex rgb в hsv
    private float[] hRGBtoHSV(String color)
    {
        float[] nrgb = new float[3];
        float[] hsv = new float[3];
        int c = Color.parseColor(color);
        nrgb[0] =   (c >> 16) & 0xFF;
        nrgb[1] = (c >> 8) & 0xFF;
        nrgb[2] =  (c >> 0) & 0xFF;
        Color.RGBToHSV(Math.round(nrgb[0]),Math.round(nrgb[1]),Math.round(nrgb[2]),hsv);
        return hsv;
    }
    //функция для изменения цвета
    private int ChangeHSV(float[] color, int hmin, int hmax, float s, float v, boolean plus)
    {
        if (plus){

            color[0] +=(float) (Math.random() * (hmax - hmin + 1) + hmin);
        }
        else {
            color[0] -=(float) (Math.random() * (hmax - hmin + 1) + hmin);
        }
        if (color[0]>360) {
            color[0] -= 360;
        }
        color[1] = (float) (Math.random()*(1-s*0.1 + 1) + 0.1*s);
        color[2] = (float) (Math.random()*(1-v*0.1 + 1) + 0.1*v);
        return Color.HSVToColor(color);
    }

    //контраст
    private String newColorContrast(String color)
    {
        float[] hsv = hRGBtoHSV(color);
        int rgb = ChangeHSV(hsv,90,180, 1, 3,true);
        String res = String.format("%06x", rgb);
        return "#"+res.substring(2);
    }
    //триада
    private String newColorTriple(String color, int id)
    {
        float[] hsv = hRGBtoHSV(color);
        int rgb;
        if (id == 1){
            rgb = ChangeHSV(hsv, 140, 180, 9,8,true);
        }
        else {
            rgb = ChangeHSV(hsv, 90, 180, (float) 9.8,7,true);
        }
        String res = String.format("%06x", rgb);
        return "#"+res.substring(2);
    }
    //аналогия для трех
    private String newColorAnalogTriple(String color, int id)
    {
        float[] hsv = hRGBtoHSV(color);
        int rgb;
        if (id == 1){
            rgb = ChangeHSV(hsv, 20, 50, (float) 8.5,(float) 9.9,true);
        }
        else {
            rgb = ChangeHSV(hsv, 20, 50, (float) 9.9,7,false);
        }
        String res = String.format("%06x", rgb);
        return "#"+res.substring(2);
    }
    //тетрада
    private String newColorTetra(String color, int id)
    {
        float[] hsv = hRGBtoHSV(color);
        int rgb;
        if (id == 1){
            rgb = ChangeHSV(hsv, 10, 100, (float) 9.5,7,true);
        }
        else if (id == 2){
            rgb = ChangeHSV(hsv, 60, 130, (float) 9.2,(float)7.5,false);
        }
        else {
            rgb = ChangeHSV(hsv, 110, 180, 9,7,false);
        }
        String res = String.format("%06x", rgb);
        return "#"+res.substring(2);
    }
    //акцент + аналогия
    private String newColorAnalogAccent(String color, int id)
    {
        float[] hsv = hRGBtoHSV(color);
        int rgb;
        if (id == 1){
            rgb = ChangeHSV(hsv, 20, 100, (float) 8.5,(float) 9.9,true);
        }
        else if (id == 2){
            rgb = ChangeHSV(hsv, 20, 100, (float) 9.9,7,false);
        }
        else {
            rgb = ChangeHSV(hsv, 20, 100, (float) 9.9,7,false);
        }
        String res = String.format("%06x", rgb);
        return "#"+res.substring(2);
    }
}
