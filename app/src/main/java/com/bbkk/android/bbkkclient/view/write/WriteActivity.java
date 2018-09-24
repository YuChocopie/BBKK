package com.bbkk.android.bbkkclient.view.write;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.WritePresenter;

public class WriteActivity extends AppCompatActivity implements WriteContract.View {
  private WriteContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_write);
    presenter = new WritePresenter(this);
  }

  @Override
  public void initView() {

  }
}
