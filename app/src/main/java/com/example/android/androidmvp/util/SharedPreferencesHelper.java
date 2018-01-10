package com.example.android.androidmvp.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by bahaso on 21/12/2017.
 */

public class SharedPreferencesHelper {
    private SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(Application application){
        sharedPreferences = application.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        Log.i("sharedPref", "sharedPref created");

    }

    public SharedPreferences getSharedPreferences(){
        return sharedPreferences;
    }
}
