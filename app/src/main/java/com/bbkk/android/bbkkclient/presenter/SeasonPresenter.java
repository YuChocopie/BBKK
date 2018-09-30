package com.bbkk.android.bbkkclient.presenter;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.bbkk.android.bbkkclient.model.SeasonModel;
import com.bbkk.android.bbkkclient.view.season.FallFragment;
import com.bbkk.android.bbkkclient.view.season.SeasonContract;
import com.bbkk.android.bbkkclient.view.season.SpringFragment;
import com.bbkk.android.bbkkclient.view.season.SummerFragment;
import com.bbkk.android.bbkkclient.view.season.WinterFragment;

public class SeasonPresenter implements SeasonContract.Presenter{

  private SeasonContract.View view;
  private SeasonModel model;
  private Fragment fragment = new Fragment();

  public SeasonPresenter(SeasonContract.View seasonView) {
    this.view = seasonView;
    this.model = new SeasonModel();
    seasonView.initView();
  }

  @Override
  public Fragment seasonFragmentGetItem(int position, int max) {
    model.setPosition(position);
    model.setMax(max);
//    if(position<0 || max<=position)
//      return null;
    switch (position) {
      case 0:
        fragment = new SpringFragment();
        break;
      case 1:
        fragment = new SummerFragment();
        break;
      case 2:
        fragment = new FallFragment();
        break;
      case 3:
        fragment = new WinterFragment();
        break;
      default:

    }
    return fragment;
  }

  @Override
  public void requestGetSeason() {
//    TODO: 서버에 보낸다

    view.startMainActivity();
  }
}
