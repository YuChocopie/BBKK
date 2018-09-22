package com.bbkk.android.bbkkclient.view.nameSetting;

public interface NameContract {

  interface View {
    void initView();

    void startTendencyActivity();

    void renderChangeName(String currentName);
  }

  interface Presenter {
    void submitAction();

    void changeNameAction();
  }
}
