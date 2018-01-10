package com.example.android.androidmvp.base;

import android.util.Log;

import com.example.android.androidmvp.util.DataManager;

/**
 * Created by bahaso on 15/12/2017.
 */

public abstract class PresenterBase<V extends MvpInterfaceBase.MvpViewInterface>
        implements MvpInterfaceBase.MvpPresenterInterface<V> {

    private V view;

    void PresenterBase(DataManager dataManager){

    }

    @Override
    public void onAttach(V view) {
        this.view=view;
        Log.i("onAttachGGZ", "gggz attach");
    }

    @Override
    public void onDetach() {
        view=null;
    }

    @Override
    public V getView() {
        return view;
    }
}
