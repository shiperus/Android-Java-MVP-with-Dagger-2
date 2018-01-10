package com.example.android.androidmvp.util.volley;

import com.android.volley.VolleyError;

import org.json.JSONException;

/**
 * Created by bahaso on 28/12/2017.
 */

public interface VolleyRequestCallback {

    void onSuccessRequest(String response) throws JSONException;
    void onFailureRequest(VolleyError volleyError);
}
