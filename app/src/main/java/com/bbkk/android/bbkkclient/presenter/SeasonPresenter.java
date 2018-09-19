package com.bbkk.android.bbkkclient.presenter;

import android.support.v4.app.Fragment;

import com.bbkk.android.bbkkclient.model.SeasonModel;
import com.bbkk.android.bbkkclient.view.season.FallFragment;
import com.bbkk.android.bbkkclient.view.season.Season;
import com.bbkk.android.bbkkclient.view.season.SpringFragment;
import com.bbkk.android.bbkkclient.view.season.SummerFragment;
import com.bbkk.android.bbkkclient.view.season.WinterFragment;

public class SeasonPresenter implements Season.Presenter{

  private Season.View seasonView;
  private SeasonModel seasonModel;
  private Fragment fragment = new Fragment();

  public SeasonPresenter(Season.View seasonView) {
    this.seasonView = seasonView;
    this.seasonModel = new SeasonModel();

  }

  @Override
  public Fragment seasonFragmentGetItem(int position, int max) {
    seasonModel.setPosition(position);
    seasonModel.setMax(max);
    if(position<0 || max<=position)
      return null;
    switch (position){
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
    }
    return fragment;
  }
}
