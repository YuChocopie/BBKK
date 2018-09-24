package com.bbkk.android.bbkkclient.presenter;

import com.bbkk.android.bbkkclient.view.review.ReviewActivity;
import com.bbkk.android.bbkkclient.view.review.ReviewContract;

public class ReviewPresenter implements ReviewContract.Presenter{
  private ReviewContract.View view;

  public ReviewPresenter(ReviewActivity view) {
    this.view = view;
    this.view.initView();
  }
}
