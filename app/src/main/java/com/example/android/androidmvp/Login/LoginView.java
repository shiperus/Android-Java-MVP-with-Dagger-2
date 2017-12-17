package com.example.android.androidmvp.Login;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.android.androidmvp.R;
import com.example.android.androidmvp.base.ActivityBase;

import javax.inject.Inject;

import butterknife.BindView;

public class LoginView extends ActivityBase implements LoginInterface.ViewInterface{

    @BindView(R.id.textInputUsername)
    TextInputLayout textInputUsername;
    @BindView(R.id.editTextUsername)
    EditText editTextUsername;
    @BindView(R.id.textInputPassword)
    TextInputLayout textInputPassword;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;

    @Inject
    LoginInterface.PresenterInterface<LoginInterface.ViewInterface> loginPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter.onAttach(LoginView.this);

    }

    @Override
    public void showMessage() {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }
}
