package com.example.android.androidmvp.util.dependency_injection.modules;

import android.app.Application;

import com.example.android.androidmvp.util.DataManager;
import com.example.android.androidmvp.util.MvpApplication;
import com.example.android.androidmvp.util.SharedPreferencesHelper;
import com.example.android.androidmvp.util.network.URLHelper;
import com.example.android.androidmvp.util.volley.VolleyRequestHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bahaso on 19/12/2017.
 */

@Module
public class ApplicationModule {
    private MvpApplication mvpApplication;

    public ApplicationModule(MvpApplication mvpApplication){
        this.mvpApplication = mvpApplication;
    }

    @Provides
    Application getApplication(){
        return mvpApplication;
    }
    @Provides
    @Singleton
    VolleyRequestHelper providesVolleyRequestHelper(){
        return new VolleyRequestHelper(mvpApplication);
    }
    @Provides
    @Singleton
    SharedPreferencesHelper providesSharedPreferencesHelper(){
        return new SharedPreferencesHelper(mvpApplication);
    }

    @Provides
    @Singleton
    DataManager providesDataManager(SharedPreferencesHelper sharedPreferencesHelper){
        return new DataManager(sharedPreferencesHelper);
    }

    @Provides
    @Singleton
    URLHelper providesUrlHelper(VolleyRequestHelper volleyRequestHelper){
        return new URLHelper(volleyRequestHelper);
    }
}
