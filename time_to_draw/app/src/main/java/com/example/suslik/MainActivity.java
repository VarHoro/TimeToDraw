package com.example.suslik;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.suslik.activities.ActIdeas;
import com.example.suslik.activities.ActPalette;
import com.example.suslik.activities.ActPractice;
import com.example.suslik.activities.ActPuzzle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void openIdeas(View view) {
        Intent intent = new Intent(this, ActIdeas.class);
        startActivity(intent);
    }

     public void openPuzzle(View view) {
     Intent intent = new Intent(this, ActPuzzle.class);
     startActivity(intent);
     }

    public void openPalette(View view) {
        Intent intent = new Intent(this, ActPalette.class);
        startActivity(intent);
    }

    public void openPractice(View view) {
        Intent intent = new Intent(this, ActPractice.class);
        startActivity(intent);
    }
/*место для пользовательских генераторов
    public void openNew(View view){
        Intent intent = new Intent(this, ActPractice.class);
        startActivity(intent);
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void GoToFav(MenuItem item) {
        Intent intent = new Intent(this, FavoriteActivity.class);
        startActivity(intent);
    }
}
