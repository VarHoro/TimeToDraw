package com.example.suslik.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.suslik.R;

public abstract class SCGenActivity extends AppCompatActivity {
    int diff;
    SharedPreferences sPreference;
    SharedPreferences.Editor editor;
    TextView text;
    ImageView bg;
    ToggleButton toggleStar;
    IGeneration generator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen);

        text = (TextView) findViewById(R.id.text);

        setGenAndBG();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.camera);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent = getIntent();

        sPreference = getSharedPreferences("favorites", Context.MODE_PRIVATE);
        editor = sPreference.edit();

        toggleStar = (ToggleButton) findViewById(R.id.toggle_star);
    }

    public void setGenAndBG(){}

    public void onToggleClicked(View v) {
        boolean on = ((ToggleButton) v).isChecked();
        String t = String.valueOf(text.getText());
        String ind = t.substring(0,3)+t.substring(t.length()/2  - 3, t.length()/2)+t.substring(t.length() - 3, t.length());
        if (on) {
            editor.putString(ind , t);
            editor.apply();
            toggleStar.setBackgroundResource(R.drawable.star_on);
        } else {
            editor.remove(ind);
            editor.apply();
            toggleStar.setBackgroundResource(R.drawable.star_off);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_inside, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        diff = Integer.parseInt(prefs.getString("listSet", "20"));
    }
*/
    public void onGenerateClicked(View view){
        TextView txt = (TextView) findViewById(R.id.text_bg);
        if (txt.getVisibility() == View.VISIBLE)
            txt.setVisibility(View.GONE);

        text.setText(generator.getResult(diff));
        toggleStar.setChecked(false);
        toggleStar.setBackgroundResource(R.drawable.star_off);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}
