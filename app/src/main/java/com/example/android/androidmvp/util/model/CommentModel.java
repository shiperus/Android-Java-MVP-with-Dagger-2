package com.example.android.androidmvp.util.model;

/**
 * Created by bahaso on 10/01/2018.
 */

public class CommentModel {
    private String name;
    private String bodyComment;

    public CommentModel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyComment() {
        return bodyComment;
    }

    public void setBodyComment(String bodyComment) {
        this.bodyComment = bodyComment;
    }
}
