package com.bbkk.android.bbkkclient.presenter;

import com.bbkk.android.bbkkclient.model.ReviewModel;
import com.bbkk.android.bbkkclient.view.review.ReviewActivity;
import com.bbkk.android.bbkkclient.view.review.ReviewContract;

import java.util.ArrayList;

public class ReviewPresenter implements ReviewContract.Presenter{
  private ReviewContract.View view;
  private ArrayList<ReviewModel> reviews = new ArrayList<>();

  public ReviewPresenter(ReviewActivity view) {
    this.view = view;
    this.view.initView();
    this.requestContentList();
  }

  private void requestContentList() {
//    TODO: 서버에 요청한다.
    reviews.add(new ReviewModel("하이1"));
    reviews.add(new ReviewModel("하이2"));
    reviews.add(new ReviewModel("하이3"));
    reviews.add(new ReviewModel("하이4"));
    reviews.add(new ReviewModel("하이5"));
    reviews.add(new ReviewModel("하이6"));
    view.renderReview(reviews);
  }
}
