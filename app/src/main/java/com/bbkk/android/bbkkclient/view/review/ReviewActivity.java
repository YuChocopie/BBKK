package com.bbkk.android.bbkkclient.view.review;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.ReviewPresenter;

import butterknife.ButterKnife;

public class ReviewActivity extends AppCompatActivity implements ReviewContract.View {
  private ReviewContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_review);
    ButterKnife.bind(this);
    presenter = new ReviewPresenter(this);
  }

  @Override
  public void initView() {

  }
}
