package com.bbkk.android.bbkkclient.presenter;

import com.bbkk.android.bbkkclient.view.write.WriteActivity;
import com.bbkk.android.bbkkclient.view.write.WriteContract;

public class WritePresenter  implements WriteContract.Presenter {
  WriteContract.View view;

  public WritePresenter(WriteActivity view) {
    this.view = view;
    this.view.initView();
  }
}
