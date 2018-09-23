package com.bbkk.android.bbkkclient.view.main;

import android.support.v7.widget.RecyclerView;

import com.bbkk.android.bbkkclient.model.Timeline;

import java.util.ArrayList;

public interface MainContract {

  interface View {
    void initView();
    void renderTimeLine(ArrayList<Timeline> timelines);
    void renderMainCounter(int size);
  }

  interface Presenter {
  }
}
