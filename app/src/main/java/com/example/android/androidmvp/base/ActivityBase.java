package com.example.android.androidmvp.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bahaso on 15/12/2017.
 */

public abstract class ActivityBase extends AppCompatActivity implements MvpInterfaceBase.ViewInterface{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void showLoading() {

    }
}
