package com.example.android.androidmvp.content;

import com.example.android.androidmvp.base.MvpInterfaceBase;

/**
 * Created by bahaso on 09/01/2018.
 */

public interface ContentInterface {
    interface ContentViewInterface extends MvpInterfaceBase.MvpViewInterface {
        void showCommentData();
    }

    interface ContentPresenterInterface<V extends ContentViewInterface>
            extends MvpInterfaceBase.MvpPresenterInterface<V> {
        void getCommentData();
    }
}
