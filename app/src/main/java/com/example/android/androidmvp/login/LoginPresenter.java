package com.example.android.androidmvp.login;

import android.util.Log;

import com.android.volley.VolleyError;
import com.example.android.androidmvp.base.PresenterBase;
import com.example.android.androidmvp.util.DataManager;
import com.example.android.androidmvp.util.network.URLHelper;
import com.example.android.androidmvp.util.volley.VolleyRequestCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

/**
 * Created by bahaso on 30/11/2017.
 */

public class LoginPresenter<V extends LoginInterface.LoginViewInterface>
        extends PresenterBase<V> implements LoginInterface.PresenterInterface<V> {


    private DataManager dataManager;
    private URLHelper urlHelper;

    public LoginPresenter(DataManager dataManager, URLHelper urlHelper) {
        this.dataManager = dataManager;
        this.urlHelper = urlHelper;
    }



    @Override
    public void validateLogin(final String username, final String password) {
        getView().disableAllErrorMessage();
        if ("".equals(username))
            getView().showUsernameErrorMessage("Username Must Not Empty");
        if ("".equals(password))
            getView().showPasswordErrorMessage("Password Must Not Empty");
        else {
            getView().showLoading();
            urlHelper.login(new VolleyRequestCallback() {
                @Override
                public void onSuccessRequest(String response) throws JSONException{
                    if(null==getView())
                        return;
                    getView().hideLoading();
                    Log.i("ggzzResponse", response);
                    JSONArray responseArray = new JSONArray(response);
                    for (int idxJsonArray =0 ; idxJsonArray<responseArray.length();idxJsonArray++){
                        JSONObject objectArray = responseArray.getJSONObject(idxJsonArray);
                        String usernameFromApi = objectArray.getString("username");
                        String passwordFromApi = objectArray.getString("username");

                        if(usernameFromApi.equals(username) && passwordFromApi.equals(password)){
                            getView().directToContentPage();
                            return;
                        }
                    }
                    getView().setDialogError("Error","You entered wrong username or password.");

                }

                @Override
                public void onFailureRequest(VolleyError volleyError) {
                    if(null==getView())
                        return;
                    getView().hideLoading();
                    getView().showVolleyErrorToast(volleyError);
                }
            });
        }
    }
}