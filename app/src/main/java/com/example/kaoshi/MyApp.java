package com.example.kaoshi;

import android.app.Application;

public class MyApp extends Application {
    public static MyApp myApp;

    public static MyApp getMyApp() {
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
    }
}
