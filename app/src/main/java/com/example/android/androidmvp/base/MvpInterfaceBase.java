package com.example.android.androidmvp.base;

/**
 * Created by bahaso on 15/12/2017.
 */

public interface MvpInterfaceBase {
    interface ViewInterface{
        void showLoading();

    }
    interface PresenterInterface<V extends ViewInterface>{
        void onAttach(V view);
        void onDetach();
        V getView();
    }

}
