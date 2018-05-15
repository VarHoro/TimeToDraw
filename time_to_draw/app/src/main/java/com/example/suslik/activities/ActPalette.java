package com.example.suslik.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.suslik.generation.GColors;
import com.example.suslik.R;

public class ActPalette extends SCGenActivity {

    TextView[] color = new TextView[5];
    IGenerationColor generator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_palette);

        diff = 31;
        generator = new GColors();

        color[0] = findViewById(R.id.color1);
        color[1] = findViewById(R.id.color2);
        color[2] = findViewById(R.id.color3);
        color[3] = findViewById(R.id.color4);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.camera);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent = getIntent();
    }

    @Override
    public void onGenerateClicked(View view){
        TextView text = (TextView) findViewById(R.id.text_bg);
        String c[] = generator.getResult(diff);
        if (text.getVisibility() == View.VISIBLE)
            text.setVisibility(View.GONE);
        for (int i=0; i<(diff/10); i++){
            SetTextViewBackgroundText(c[i], color[i]);
        }
    }

    private void SetTextViewBackgroundText(String str, TextView text){
        text.setBackgroundColor(Color.parseColor(str));
        text.setText(str);
        if (text.getVisibility() == View.GONE)
            text.setVisibility(View.VISIBLE);
    }
}
