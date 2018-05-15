package com.example.suslik;

import android.os.Bundle;
import com.example.suslik.R;

public class PreferenceFragment extends android.preference.PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preference);
    }
}
