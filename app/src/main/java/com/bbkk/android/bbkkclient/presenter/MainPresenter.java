package com.bbkk.android.bbkkclient.presenter;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.model.MainModel;
import com.bbkk.android.bbkkclient.model.Timeline;
import com.bbkk.android.bbkkclient.view.main.MainContract;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {

  private MainContract.View view;
  private MainModel mainModel;
  private ArrayList<Timeline> timelines = new ArrayList<>();

  public MainPresenter(MainContract.View mainView) {
    this.view = mainView;
    this.mainModel = new MainModel();
    view.initView();
    this.requestContentList();
  }

  private void requestContentList() {
//    TODO: 서버에 요청한다.
  }
}
