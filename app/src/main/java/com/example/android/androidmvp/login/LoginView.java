package com.example.android.androidmvp.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android.androidmvp.R;
import com.example.android.androidmvp.base.ActivityBase;
import com.example.android.androidmvp.content.ContentView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginView extends ActivityBase implements LoginInterface.LoginViewInterface {

    @BindView(R.id.textInputUsername)
    TextInputLayout textInputUsername;
    @BindView(R.id.editTextUsername)
    EditText editTextUsername;
    @BindView(R.id.textInputPassword)
    TextInputLayout textInputPassword;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;

    @Inject
    LoginPresenter<LoginInterface.LoginViewInterface> loginPresenter;

    @OnClick(R.id.loginButton)
    public void clickLoginButton(View view){
        String userName = editTextUsername.getText().toString();
        String userPassword= editTextPassword.getText().toString();
        loginPresenter.validateLogin(userName,userPassword);
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        loginPresenter.onAttach(LoginView.this);
    }



    @Override
    public void showUsernameErrorMessage(String errorMessage) {
        textInputUsername.setErrorEnabled(true);
        textInputUsername.setError(errorMessage);
    }

    @Override
    public void disableAllErrorMessage() {
        textInputUsername.setErrorEnabled(false);
        textInputPassword.setErrorEnabled(false);
    }


    @Override
    public void showPasswordErrorMessage(String errorMessage) {
        textInputPassword.setErrorEnabled(true);
        textInputPassword.setError(errorMessage);
    }

    @Override
    public void directToContentPage() {
        Intent intent = new Intent(this, ContentView.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setDialogError(String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("Ok",null);
        builder.show();


    }


}
