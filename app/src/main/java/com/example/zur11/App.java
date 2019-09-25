package com.example.zur11;

import android.app.AppComponentFactory;
import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);


    }
}
