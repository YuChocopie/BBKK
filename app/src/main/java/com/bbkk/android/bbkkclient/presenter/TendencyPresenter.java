package com.bbkk.android.bbkkclient.presenter;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;

import com.bbkk.android.bbkkclient.model.TendencyModel;
import com.bbkk.android.bbkkclient.view.tendency.TendencyContract;
import com.bbkk.android.bbkkclient.view.tendency.TendencyFragment_traveler;
import com.bbkk.android.bbkkclient.view.tendency.TendencyFragment_foodFighter;
import com.bbkk.android.bbkkclient.view.tendency.TendencyFragment_explorer;
import com.bbkk.android.bbkkclient.view.tendency.TendencyFragment_niggard;
import com.bbkk.android.bbkkclient.view.tendency.TendencyFragment_artist;

import static com.bbkk.android.bbkkclient.presenter.NamePresenter.USER_NAME;

public class TendencyPresenter implements TendencyContract.Presenter{
  private TendencyContract.View view;
  private TendencyModel tendencyModel;
  private SharedPreferences userData;
  private Fragment fragment = new Fragment();

  public TendencyPresenter(TendencyContract.View tendencyView, SharedPreferences userData) {
    this.view = tendencyView;
    this.tendencyModel = new TendencyModel();
    this.userData = userData;
    this.view.initView();
    this.getUserName();
  }

  private void getUserName() {
    String currentName = userData.getString(USER_NAME, "");
    view.renderName(currentName);
  }

  @Override
  public Fragment tendencyFragmentGetItem(int position, int max) {
    tendencyModel.setPosition(position);
    tendencyModel.setMax(max);
    if(position<0 || max<=position)
      return null;
    switch (position){
      case 0:
        fragment = new TendencyFragment_foodFighter();
        break;
      case 1:
        fragment = new TendencyFragment_artist();
        break;
      case 2:
        fragment = new TendencyFragment_traveler();
        break;
      case 3:
        fragment = new TendencyFragment_explorer();
        break;
      case 4:
        fragment = new TendencyFragment_niggard();
        break;
      default:

    }
    return fragment;
  }
}
