package com.bbkk.android.bbkkclient.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.bbkk.android.bbkkclient.api.BbkkApiDefinition;
import com.bbkk.android.bbkkclient.view.nameSetting.NameContract;
import com.bbkk.android.bbkkclient.model.NameModel;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
//  TODO: 서버에 닉네임 요청하기_o
    NameRetrofit();
  }

  @Override
  public void NameRetrofit() {
    BbkkApiDefinition bbkkApiDefinition = BbkkApiDefinition.retrofit.create(BbkkApiDefinition.class);
    Call<NameModel> call = bbkkApiDefinition.getRandomName();
    call.enqueue(new Callback<NameModel>() {
      @Override
      public void onResponse(Call<NameModel> call, Response<NameModel> response) {
        view.renderChangeName((response.body().result.nickname));
      }
      @Override
      public void onFailure(Call<NameModel>call, Throwable t) {
        Log.e("onFailure","Call NickName Fail");
      }
    });
  }
}
