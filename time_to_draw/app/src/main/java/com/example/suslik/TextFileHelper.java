package com.example.suslik;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import android.content.Context;
import android.widget.Toast;

public class TextFileHelper {

    Context mContext;

    public TextFileHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void flashMessage(String customText) {
        try {

            Toast.makeText(mContext, customText, Toast.LENGTH_SHORT).show();

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(Context c,String filename, String content){
        File file = new File(c.getFilesDir(), filename);
        if (!file.exists()){
            file.mkdir();
        }
        try {
            File gpxfile = new File(file, filename);
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(content);
            writer.flush();
            writer.close();
            flashMessage("File saved and created");

        }catch (Exception e){
            e.printStackTrace();
            flashMessage("Failed to create");
        }
    }
}
