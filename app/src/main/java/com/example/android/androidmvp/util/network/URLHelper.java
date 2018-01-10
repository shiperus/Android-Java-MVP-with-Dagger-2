package com.example.android.androidmvp.util.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.android.androidmvp.util.volley.VolleyRequestCallback;
import com.example.android.androidmvp.util.volley.VolleyRequestHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by bahaso on 29/12/2017.
 */

public class URLHelper{
    private final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private String requestUrl;
    private VolleyRequestHelper volleyRequestHelper;

    public URLHelper(VolleyRequestHelper volleyRequestHelper) {
        this.volleyRequestHelper = volleyRequestHelper;
        Log.i("uriHelperCreated", "UriHelper created");

    }

    public void login(VolleyRequestCallback volleyRequestCallback) {
        requestUrl = BASE_URL + "/users";
        volleyRequestHelper.addNewRequest(
                Request.Method.GET,
                requestUrl,
                "TAG",
                new byte[]{},
                volleyRequestCallback
                );
    }

    public void getComments(VolleyRequestCallback volleyRequestCallback) {
        requestUrl = BASE_URL + "/comments";
        volleyRequestHelper.addNewRequest(
                Request.Method.GET,
                requestUrl,
                "TAG",
                new byte[]{},
                volleyRequestCallback
        );
    }


}
