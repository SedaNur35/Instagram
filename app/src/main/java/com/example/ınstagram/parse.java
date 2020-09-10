package com.example.ınstagram;

import android.app.Application;

import com.parse.Parse;

public class parse extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        //başlatılma işlemleri
        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("KM9iRHE0OtZssFrOPC1DME7Y1XSdTSygBYlrNAcW")
        .clientKey("dVjJgzD1JOawsUXf7WSqZpqbDi9lzWJZiysc4pDL")
        .server("https://parseapi.back4app.com/")
        .build());

    }
}
