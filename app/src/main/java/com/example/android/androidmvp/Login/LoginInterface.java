package com.example.android.androidmvp.Login;

import com.example.android.androidmvp.base.MvpInterfaceBase;

/**
 * Created by bahaso on 30/11/2017.
 */

public interface LoginInterface {

    interface ViewInterface extends MvpInterfaceBase.ViewInterface{
        void showMessage();
        void showProgressDialog();
        void hideProgressDialog();
    }

    interface PresenterInterface<V extends ViewInterface>
            extends MvpInterfaceBase.PresenterInterface<V>{
        void validate(String username,String password);
    }

    interface ModelInterface{
        void login(String username,String password);
    }
}
