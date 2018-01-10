package com.example.android.androidmvp.util;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by bahaso on 22/12/2017.
 */

public class DataManager {
    //shared pref
    private SharedPreferencesHelper sharedPreferencesHelper;
    //for sqlite or realm

    public DataManager(
            SharedPreferencesHelper sharedPreferencesHelper
    ){
        this.sharedPreferencesHelper=sharedPreferencesHelper;
        Log.i("dtmCreated", "DataManager created");
    }

    public SharedPreferencesHelper getSharedPreferencesHelper(){return sharedPreferencesHelper; };
}
