package com.bbkk.android.bbkkclient.presenter;

import com.bbkk.android.bbkkclient.view.splash.SplashContract;

public class SplashPresenter implements SplashContract.Presenter {
  SplashContract.View view;
  private boolean hasNickName = false;

  public SplashPresenter(SplashContract.View view) {
    this.view = view;
    this.view.initView();
  }

  @Override
  public void activityManager() {
    if (hasNickName) {
      view.startTendencyActivity();
    } else {
      view.startNameActivity();
    }
  }

  @Override
  public void requestAction() {
//    TODO: UUID 값 가져오기
//    TODO: 서버에 값 보내기
    view.renderView();
  }
}
