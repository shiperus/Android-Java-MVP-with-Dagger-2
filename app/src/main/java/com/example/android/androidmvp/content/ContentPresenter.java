package com.example.android.androidmvp.content;

import com.android.volley.VolleyError;
import com.example.android.androidmvp.base.PresenterBase;
import com.example.android.androidmvp.util.DataManager;
import com.example.android.androidmvp.util.model.CommentModel;
import com.example.android.androidmvp.util.network.URLHelper;
import com.example.android.androidmvp.util.volley.VolleyRequestCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by bahaso on 09/01/2018.
 */

public class ContentPresenter<V extends ContentInterface.ContentViewInterface>
        extends PresenterBase<V> implements ContentInterface.ContentPresenterInterface<V>{

    private DataManager dataManager;
    private URLHelper urlHelper;

    public ContentPresenter(DataManager dataManager, URLHelper urlHelper) {
        this.dataManager = dataManager;
        this.urlHelper = urlHelper;
    }

    @Override
    public void getCommentData() {
        getView().showLoading();
        urlHelper.getComments(new VolleyRequestCallback() {
            @Override
            public void onSuccessRequest(String response) throws JSONException {
                if(null==getView())
                    return;
                getView().hideLoading();
                ArrayList<CommentModel> arrayListComment=new ArrayList<>();
                JSONArray jsonArray = new JSONArray(response);
                for(int idxJsonArray=0;idxJsonArray<jsonArray.length();idxJsonArray++){
                    JSONObject jsonObject = jsonArray.getJSONObject(idxJsonArray);
                    String name = jsonObject.getString("name");
                    String body = jsonObject.getString("body");
                    CommentModel commentModel = new CommentModel();
                    commentModel.setName(name);
                    commentModel.setBodyComment(body);
                    arrayListComment.add(commentModel);
                }
                getView().showCommentData();

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
