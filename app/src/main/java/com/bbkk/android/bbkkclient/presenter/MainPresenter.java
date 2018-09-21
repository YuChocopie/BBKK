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

  private MainContract.View mainView;
  private MainModel mainModel;
  private ArrayList<Timeline> timelines = new ArrayList<>();

  public MainPresenter(MainContract.View mainView) {
    this.mainView = mainView;
    this.mainModel = new MainModel();
    mainView.initView();
  }

  @Override
  public void callRecyclerView(RecyclerView mRecyclerView) {
    mRecyclerView.setHasFixedSize(true);
    LinearLayoutManager layoutManager = new LinearLayoutManager((Context) mainView);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(layoutManager);
    timelines.add(new Timeline(R.drawable.choice,"남한산성"));
    timelines.add(new Timeline(R.drawable.choice,"백두산"));
    timelines.add(new Timeline(R.drawable.choice,"가을음악회"));
    timelines.add(new Timeline(R.drawable.choice,"유정이와함께 한강 자전거"));
    TimeLineAdapter timeLineAdapter = new TimeLineAdapter(timelines);
    mRecyclerView.setAdapter(timeLineAdapter);
  }
}
