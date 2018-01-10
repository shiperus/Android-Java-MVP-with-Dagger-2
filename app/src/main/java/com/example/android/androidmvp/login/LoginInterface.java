package com.example.android.androidmvp.login;

import android.app.Activity;
import android.content.Intent;

import com.example.android.androidmvp.base.MvpInterfaceBase;

/**
 * Created by bahaso on 30/11/2017.
 */

public interface LoginInterface {

    interface LoginViewInterface extends MvpInterfaceBase.MvpViewInterface {
        void showUsernameErrorMessage(String errorMessage);
        void disableAllErrorMessage();
        void showPasswordErrorMessage(String errorMessage);
        void directToContentPage();
        void setDialogError(String title,String message);
    }

    interface PresenterInterface<V extends LoginViewInterface>
            extends MvpInterfaceBase.MvpPresenterInterface<V> {
        void validateLogin(String username, String password);
    }
}
