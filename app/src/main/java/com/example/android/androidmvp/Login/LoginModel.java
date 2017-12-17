package com.example.android.androidmvp.Login;

import com.android.volley.VolleyError;
import com.example.android.androidmvp.util.interfaces.VolleyCallback;

import org.json.JSONException;

/**
 * Created by bahaso on 05/12/2017.
 */

public class LoginModel implements LoginInterface.ModelInterface, VolleyCallback {
    private LoginInterface.PresenterInterface presenterLogin;

    LoginModel(LoginInterface.PresenterInterface presenterLogin){
        this.presenterLogin=presenterLogin;
    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void onSuccessResponse(String response) throws JSONException {

    }

    @Override
    public void onFailureResponse(VolleyError error) {

    }

}
