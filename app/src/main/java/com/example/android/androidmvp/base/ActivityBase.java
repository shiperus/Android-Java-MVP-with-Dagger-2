package com.example.android.androidmvp.base;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.android.androidmvp.util.MvpApplication;
import com.example.android.androidmvp.util.dependency_injection.component.ActivityComponent;
import com.example.android.androidmvp.util.dependency_injection.component.DaggerActivityComponent;
import com.example.android.androidmvp.util.dependency_injection.modules.ActivityModule;

/**
 * Created by bahaso on 15/12/2017.
 */

public abstract class ActivityBase extends AppCompatActivity implements MvpInterfaceBase.MvpViewInterface {

    private ActivityComponent activityComponent;

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((MvpApplication)getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
        initProgressDialog();
    }

    private void initProgressDialog(){
        progressDialog = new ProgressDialog(this);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        progressDialog.setMessage("Loading... Please Wait");
        progressDialog.setCancelable(false);
    }

    @Override
    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public void showVolleyErrorToast(VolleyError error) {
        Toast.makeText(this, error +"", Toast.LENGTH_SHORT).show();
    }
}
