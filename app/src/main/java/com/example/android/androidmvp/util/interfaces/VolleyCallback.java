package com.example.android.androidmvp.util.interfaces;

import com.android.volley.VolleyError;

import org.json.JSONException;

/**
 * Created by bahaso on 05/12/2017.
 */

public interface VolleyCallback {
    void onSuccessResponse(String response) throws JSONException;
    void onFailureResponse(VolleyError error);

}
