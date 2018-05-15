package com.example.suslik.generation;

import android.content.Context;

import com.example.suslik.activities.IGeneration;
import com.example.suslik.R;

import java.util.Random;

public class GIdeas extends GWords implements IGeneration {

    public GIdeas(Context current){
        this.current = current;
    }

    @Override
    public String getResult(int diff){
        String res;
        switch (diff){
            case 10:
            case 11:
                res = SimpleCase(diff, 0);
                break;
            case 20:
            case 21:
            case 22:
                res = MiddleCase(diff);
                break;
            case 30:
            case 31:
                res = TopCase(diff);
                break;
            default: res = "Type is not right";
        }
        return res.substring(0,1).toUpperCase() + res.substring(1);
    }

    private String SimpleCase(int ca, int c){
        Random rn = new Random();
        int gen, n = getLength(R.raw.noun);
        String b, buff = getRawString(R.raw.noun, rn.nextInt(n));
        gen = getFirstCharToInt(buff);
        String res, adj, noun = getWordByChase(buff, c);
        n = getLength(R.raw.adj);

        switch (ca){
            case 10:
                buff = getRawString(R.raw.adj, rn.nextInt(n));
                adj = getWordByChaseAndGender(buff, c, gen);
                res = adj + " " + noun;
                return res;
            case 11:
                buff = getRawString(R.raw.adj, rn.nextInt(n));
                adj = getWordByChaseAndGender(buff, c, gen);
                res = adj + ", ";
                b = getRawString(R.raw.adj, rn.nextInt(n));
                while ((b.compareTo(buff)) == 0){
                    b = getRawString(R.raw.adj, rn.nextInt(n));
                }
                adj = getWordByChaseAndGender(b, c, gen);
                res += adj + " " + noun;
                return res;
            default:
                return "not found";
        }
    }
    private String MiddleCase(int ca){
        Random rn = new Random();
        int cl = 0, n;
        String res, prep;

        switch (ca)
        {
            case 20:
                res = SimpleCase((rn.nextInt(1))+10, cl) + " ";
                n = getLength(R.raw.place);
                res += getRawString(R.raw.place, rn.nextInt(n));
                return res;
            case 21:
                n = getLength(R.raw.prep);
                prep = getRawString(R.raw.prep, rn.nextInt(n));
                cl = getFirstCharToInt(prep);
                prep = prep.substring(1);
                res = SimpleCase((rn.nextInt(1))+10, 0) + " " + prep + " " + SimpleCase(10, cl);
                return res;
            case 22:
                n = getLength(R.raw.prep);
                prep = getRawString(R.raw.prep, rn.nextInt(n));
                cl = getFirstCharToInt(prep);
                prep = prep.substring(1);
                res = SimpleCase((rn.nextInt(1))+10, 0) + " " + prep + " "
                        + getWordByChase(getRawString(R.raw.noun, rn.nextInt(getLength(R.raw.noun))), cl);
                return res;
            default:
                return "not found";
        }
    }
    private String TopCase(int ca){
        Random rn = new Random();
        int cl = 0, n;
        String res, verb, noun, prep;
        switch (ca){
            case 30:
                res = SimpleCase((rn.nextInt(1))+10, cl) + " ";
                n = getLength(R.raw.verb);
                verb = getRawString(R.raw.verb, rn.nextInt(n));
                n = getLength(R.raw.prep);
                prep = getRawString(R.raw.prep, rn.nextInt(n));
                cl = getFirstCharToInt(prep);
                prep = prep.substring(1);
                n = getLength(R.raw.noun);
                noun = getWordByChase(getRawString(R.raw.noun, rn.nextInt(n)), cl);
                res += verb + " " + prep + " " + noun;
                return res;
            case 31:
                n = getLength(R.raw.readytogo);
                res = SimpleCase((rn.nextInt(1))+10, cl) + " " + getRawString(R.raw.readytogo, rn.nextInt(n)) ;
                return res;
            default:
                return "not found";
        }
    }
}
