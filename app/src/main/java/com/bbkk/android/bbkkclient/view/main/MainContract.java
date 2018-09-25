package com.bbkk.android.bbkkclient.view.main;

import com.bbkk.android.bbkkclient.model.TimelineEntry;

import java.util.ArrayList;

public interface MainContract {

  interface View {
    void initView();
    void renderTimeLine(ArrayList<TimelineEntry> timelineEntries);
    void renderMainCounter(int size);
  }
  interface Presenter {
    void TimeLineRetrofit();
  }
}
