package com.phonepe.parentapp;

import android.content.Context;
import android.content.SharedPreferences;

public class DataStorage {

    private static final String SHAREDPREF_FILENAME = "sharedpref_filename";
    private static final String KEY = "key";

    private static SharedPreferences sharedPreferences;

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(SHAREDPREF_FILENAME, Context.MODE_PRIVATE);
    }

    public static void saveText(String text) {
        sharedPreferences.edit().putString(KEY, text).commit();
    }

    public static String getText() {
        return sharedPreferences.getString(KEY, "");
    }

}
