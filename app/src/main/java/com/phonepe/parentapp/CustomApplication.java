package com.phonepe.parentapp;

import android.app.Application;


public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataStorage.init(this.getApplicationContext());
    }
}
