package com.bbkk.android.bbkkclient.presenter;

import com.bbkk.android.bbkkclient.view.nameSetting.NameContract;
import com.bbkk.android.bbkkclient.model.NameModel;

import java.util.ArrayList;
import java.util.Random;

public class NamePresenter implements NameContract.Presenter {

  NameContract.View view;
  NameModel model;

  public NamePresenter(NameContract.View nameView) {
    this.view = nameView;
    this.model = new NameModel();
    view.initView();
  }

  @Override
  public void submitAction() {
//    TODO: SharedPreference에 닉네임 등록하기.
//    TODO: 서버에 데이터 닉네임 등록하기.
//    TODO: 서버에서 닉네임 등록 성공 시 다음 Activity 실행하기
    view.startTendencyActivity();
  }

  @Override
  public void changeNameAction() {
//    TODO: 서버에 닉네임 요청하기
    String currentName = this.renderRandomName();
    view.renderChangeName(currentName);
  }

  private String renderRandomName() {
    String[] names = {
      "코딩하는 오징어",
      "게임하는 재르시",
      "홍성사는 다미니",
      "마라토너 고으니",
      "커피타는 유정쓰",
      "싸라있네 현태쓰"
    };
    Random random = new Random();
    int randomNum = random.nextInt(names.length);
    return names[randomNum];
  }
}
