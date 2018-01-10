package com.example.android.androidmvp.util.volley;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NoConnectionError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.androidmvp.BuildConfig;

import org.json.JSONException;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by bahaso on 28/12/2017.
 */

public class VolleyRequestHelper implements Response.Listener<String>, Response.ErrorListener {

    private RequestQueue requestQueue;
    private byte[] requestParams;
    private String URL;
    private VolleyRequestCallback volleyRequestCallback;

    public VolleyRequestHelper(Application application) {
        requestQueue = Volley.newRequestQueue(application);
    }

    public void addNewRequest(
            int METHOD,
            String URL,
            String REQUEST_TAG,
            byte[] requestParams,
            VolleyRequestCallback volleyRequestCallback
    ) {
        this.requestParams = requestParams;
        this.URL = URL;
        this.volleyRequestCallback = volleyRequestCallback;
        StringRequest stringRequest = new StringRequest(METHOD, URL, this, this) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return VolleyRequestHelper.this.requestParams;
            }

        };
        stringRequest.setRetryPolicy(
                new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        stringRequest.setTag(REQUEST_TAG);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onResponse(String response) {
        if (BuildConfig.DEBUG) {
            String s = new String(requestParams);
            Log.d(VolleyRequestHelper.class.getSimpleName(), "Params: " + s);
            Log.d(VolleyRequestHelper.class.getSimpleName(), "URL: " + URL + " Response: " + response);
        }
        try {
            volleyRequestCallback.onSuccessRequest(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        volleyRequestCallback.onFailureRequest(error);
    }
}
