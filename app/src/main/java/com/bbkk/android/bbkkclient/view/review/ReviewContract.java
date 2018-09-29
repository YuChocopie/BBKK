package com.bbkk.android.bbkkclient.view.review;

import com.bbkk.android.bbkkclient.model.ReviewModel;

import java.util.ArrayList;

public interface ReviewContract {
  interface View {
    void initView();
    void renderReview(ArrayList<ReviewModel> reviews);
  }
  interface Presenter {

    void deleteReview();
  }
}
