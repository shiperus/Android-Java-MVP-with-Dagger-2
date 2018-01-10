package com.example.android.androidmvp.util.dependency_injection.component;

import android.app.Application;

import com.example.android.androidmvp.util.DataManager;
import com.example.android.androidmvp.util.MvpApplication;
import com.example.android.androidmvp.util.SharedPreferencesHelper;
import com.example.android.androidmvp.util.dependency_injection.modules.ApplicationModule;
import com.example.android.androidmvp.util.network.URLHelper;
import com.example.android.androidmvp.util.volley.VolleyRequestHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bahaso on 21/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MvpApplication application);

    DataManager getDataManager();
    URLHelper getUrlHelper();
}
