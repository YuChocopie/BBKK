package com.bbkk.android.bbkkclient.view.nameSetting;

public interface NameContract {

  interface View {
    //닉네임 칸에 뿌려주기
    void showRandomName(String name);
    void initView();
  }

  interface Presenter {
    //가지고 있는 닉네임 보내 준다 & 새거 받아와
    void callRandomname(String randomname);
  }
}
