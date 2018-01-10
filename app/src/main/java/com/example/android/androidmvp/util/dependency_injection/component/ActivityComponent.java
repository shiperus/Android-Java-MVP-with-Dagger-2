package com.example.android.androidmvp.util.dependency_injection.component;

import com.example.android.androidmvp.content.ContentView;
import com.example.android.androidmvp.login.LoginView;
import com.example.android.androidmvp.util.DataManager;
import com.example.android.androidmvp.util.dependency_injection.customscopes.ActivityScope;
import com.example.android.androidmvp.util.dependency_injection.modules.ActivityModule;
import com.example.android.androidmvp.util.dependency_injection.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bahaso on 15/12/2017.
 */

@ActivityScope
@Component(dependencies = {ApplicationComponent.class},modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(LoginView view);
    void inject(ContentView view);

}
