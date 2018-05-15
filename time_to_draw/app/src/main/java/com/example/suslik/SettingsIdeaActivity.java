package com.example.suslik;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

public class SettingsIdeaActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_idea);

        getFragmentManager().beginTransaction().add(R.id.set_idea_content, new SetIdeasFragment()).commit();

    }

    public static class SetIdeasFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_idea);
        }
    }
}
