package com.example.android.androidmvp.util;

import android.app.Application;

import com.example.android.androidmvp.util.dependency_injection.component.ApplicationComponent;
import com.example.android.androidmvp.util.dependency_injection.component.DaggerApplicationComponent;
import com.example.android.androidmvp.util.dependency_injection.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by bahaso on 13/12/2017.
 */

public class MvpApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
