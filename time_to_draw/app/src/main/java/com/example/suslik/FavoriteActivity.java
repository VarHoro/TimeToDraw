package com.example.suslik;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ListView list = (ListView) findViewById(R.id.list_fav);

        SharedPreferences sharedPreferences = getSharedPreferences("favorites", Context.MODE_PRIVATE);
        Map<String,?> allPref = sharedPreferences.getAll();
        List<String> strList = new ArrayList<String>();
        for (Map.Entry<String,?> entry : allPref.entrySet()){
            strList.add(entry.getValue().toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strList);
        list.setAdapter(adapter);
    }

}


