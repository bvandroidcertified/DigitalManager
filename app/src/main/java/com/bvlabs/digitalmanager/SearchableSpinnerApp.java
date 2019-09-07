package com.bvlabs.digitalmanager;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;

import gr.escsoft.michaelprimez.searchablespinner.SearchableSpinner;

public class SearchableSpinnerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

}
