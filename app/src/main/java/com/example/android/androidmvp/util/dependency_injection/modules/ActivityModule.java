package com.example.android.androidmvp.util.dependency_injection.modules;

import android.app.Activity;
import android.content.Context;

import com.example.android.androidmvp.content.ContentInterface;
import com.example.android.androidmvp.content.ContentPresenter;
import com.example.android.androidmvp.login.LoginInterface;
import com.example.android.androidmvp.login.LoginPresenter;
import com.example.android.androidmvp.base.ActivityBase;
import com.example.android.androidmvp.util.DataManager;
import com.example.android.androidmvp.util.SharedPreferencesHelper;
import com.example.android.androidmvp.util.dependency_injection.customscopes.ActivityScope;
import com.example.android.androidmvp.util.network.URLHelper;
import com.example.android.androidmvp.util.volley.VolleyRequestHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bahaso on 15/12/2017.
 */
@Module
public class ActivityModule {
    private ActivityBase activityBase;


    public ActivityModule(ActivityBase activityBase){
        this.activityBase = activityBase;
    }

//    @Provides
//    Context getContext(){
//        return activityBase;
//    }
    @Provides
    @ActivityScope
    LoginPresenter<LoginInterface.LoginViewInterface> providesLoginPresenter
            (DataManager dataManager, URLHelper urlHelper){
        return new LoginPresenter<>(dataManager,urlHelper);
    }

    @Provides
    @ActivityScope
    ContentPresenter<ContentInterface.ContentViewInterface> providesContentPresenter
            (DataManager dataManager, URLHelper urlHelper){
        return new ContentPresenter<>(dataManager,urlHelper);
    }


}
