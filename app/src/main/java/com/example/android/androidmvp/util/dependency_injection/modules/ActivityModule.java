package com.example.android.androidmvp.util.dependency_injection.modules;

import com.example.android.androidmvp.Login.LoginInterface;
import com.example.android.androidmvp.Login.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bahaso on 15/12/2017.
 */
@Module
public class ActivityModule {

    @Provides
    @Singleton
    LoginInterface.PresenterInterface<LoginInterface.ViewInterface> providesLoginPresenter(
            LoginInterface.PresenterInterface<LoginInterface.ViewInterface> loginPresenter
    ) {
        return loginPresenter;
    }
}
