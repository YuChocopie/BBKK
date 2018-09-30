package com.bbkk.android.bbkkclient.view.season;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.SeasonPresenter;
import com.bbkk.android.bbkkclient.view.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeasonActivity extends AppCompatActivity implements SeasonContract.View {
  private int MAX_PAGE=4;
  @BindView(R.id.vp_season_layout)
  public ViewPager vpSeason;
  @BindView(R.id.tv_season_button)
  public TextView tvSeasonBtn;
  @BindView(R.id.tv_season_result)
  public TextView tvSeasonResult;

  private SeasonContract.Presenter presenter;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_season);
    ButterKnife.bind(this);
    presenter();
  }

  private void presenter() {
    presenter = new SeasonPresenter(this);
  }

  @Override
  public void initView() {
    vpSeason.setAdapter(new adapter(getSupportFragmentManager()));
    this.submitAction();
  }

  private void submitAction() {
    tvSeasonBtn.setOnClickListener((__) -> {
      presenter.requestGetSeason();
    });
  }

  @Override
  public void startMainActivity() {
    startActivity(new Intent(this, MainActivity.class));
    finish();
  }

  private class adapter extends FragmentPagerAdapter {

    public adapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("NUM", String.valueOf(position));
      return presenter.seasonFragmentGetItem(position,MAX_PAGE);
    }

    @Override
    public int getCount() {
      return MAX_PAGE;
    }
  }
}

