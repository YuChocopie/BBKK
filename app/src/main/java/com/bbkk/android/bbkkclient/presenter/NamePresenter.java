package com.bbkk.android.bbkkclient.presenter;

import com.bbkk.android.bbkkclient.view.nameSetting.NameContract;
import com.bbkk.android.bbkkclient.model.NameModel;

public class NamePresenter implements NameContract.Presenter {

  NameContract.View nameView;
  NameModel nameModel;

  public NamePresenter(NameContract.View nameView) {
    this.nameView = nameView;
    this.nameModel = new NameModel();
    nameView.initView();
    startPresenter();
  }

  private void startPresenter() {
    callRandomname("이름 넣기");
  }

  @Override
  public void callRandomname(String randomname) {
    nameModel.setUsermname(randomname);
    nameView.showRandomName(nameModel.getRandomname());
  }
}
