package com.bbkk.android.bbkkclient.view.season;

import android.support.v4.app.Fragment;

public interface SeasonContract {
  interface View {
    void initView();
  }
  interface Presenter {
    Fragment seasonFragmentGetItem(int position, int max);
  }
}
