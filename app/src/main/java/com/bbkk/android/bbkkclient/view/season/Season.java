package com.bbkk.android.bbkkclient.view.season;

import android.support.v4.app.Fragment;

public interface Season {
  interface View { }
  interface Presenter {
    Fragment seasonFragmentGetItem(int position, int max);
  }
}
