package com.example.android.androidmvp.base;

import android.util.Log;

/**
 * Created by bahaso on 15/12/2017.
 */

public abstract class PresenterBase<V extends MvpInterfaceBase.ViewInterface>
        implements MvpInterfaceBase.PresenterInterface<V> {

    private V view;

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
