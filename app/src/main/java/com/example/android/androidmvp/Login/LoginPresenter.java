package com.example.android.androidmvp.Login;

import com.example.android.androidmvp.base.PresenterBase;

import javax.inject.Inject;

/**
 * Created by bahaso on 30/11/2017.
 */

public class LoginPresenter extends PresenterBase implements LoginInterface.PresenterInterface {
    private final LoginInterface.ViewInterface viewLogin;
    private final LoginInterface.ModelInterface modelLogin;

    @Inject
    LoginPresenter (LoginInterface.ViewInterface viewLogin){
        this.viewLogin = viewLogin;
        modelLogin = new LoginModel(this);
    }

    @Override
    public void validate(String username, String password) {
        modelLogin.login(username,password);
    }
}
