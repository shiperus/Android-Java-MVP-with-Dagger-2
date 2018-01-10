package com.example.android.androidmvp.base;

import com.android.volley.VolleyError;
import com.example.android.androidmvp.util.dependency_injection.component.ActivityComponent;

/**
 * Created by bahaso on 15/12/2017.
 */

public interface MvpInterfaceBase {
    interface MvpViewInterface {
        void showLoading();
        void hideLoading();
        ActivityComponent getActivityComponent();
        void showVolleyErrorToast(VolleyError error);
    }
    interface MvpPresenterInterface<V extends MvpViewInterface>{
        void onAttach(V view);
        void onDetach();
        V getView();
    }

}
