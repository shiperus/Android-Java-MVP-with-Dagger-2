package com.example.android.androidmvp.util.dependency_injection.component;

import com.example.android.androidmvp.Login.LoginView;
import com.example.android.androidmvp.util.dependency_injection.modules.ActivityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bahaso on 15/12/2017.
 */

@Singleton
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(LoginView view);
}
