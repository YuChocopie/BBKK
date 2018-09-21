package com.bbkk.android.bbkkclient.view.main;

import android.support.v7.widget.RecyclerView;

public interface MainContract {

  interface View {
    void initView();
  }

  interface Presenter {
    void callRecyclerView(RecyclerView mRecyclerView);
  }
}
