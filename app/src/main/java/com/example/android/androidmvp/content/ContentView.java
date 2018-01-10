package com.example.android.androidmvp.content;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.androidmvp.R;
import com.example.android.androidmvp.base.ActivityBase;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentView extends ActivityBase implements ContentInterface.ContentViewInterface{

    @BindView(R.id.listViewComment)
    ListView listViewComment;

    @Inject
    ContentPresenter<ContentInterface.ContentViewInterface> contentPresenter;

    @Override
    protected void onDestroy() {
        contentPresenter.onDetach();
        super.onDestroy();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        contentPresenter.onAttach(this);
        contentPresenter.getCommentData();
    }

    @Override
    public void showCommentData() {

        listViewComment.setAdapter();
    }
}
