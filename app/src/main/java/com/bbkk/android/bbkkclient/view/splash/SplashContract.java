package com.bbkk.android.bbkkclient.view.splash;

public interface SplashContract {
  interface View {
    void initView();
    void renderView();
    void startTendencyActivity();
    void startNameActivity();
  }
  interface Presenter {
    void activityManager();
    void requestAction();
  }
}
