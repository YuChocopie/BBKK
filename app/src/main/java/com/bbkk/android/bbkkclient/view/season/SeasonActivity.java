package com.bbkk.android.bbkkclient.view.season;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.SeasonPresenter;
import com.bbkk.android.bbkkclient.view.main.MainActivity;

public class SeasonActivity extends AppCompatActivity implements Season.View {

  private static final String SEASON_TITLE = "Season";
  int MAX_PAGE=4;
  Season.Presenter presenter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_season);
    presenter = new SeasonPresenter(this);
    init();
  }

  private void init() {
    ViewPager viewPager = findViewById(R.id.season_viewpager);
    ImageButton nextPageButton = findViewById(R.id.btn_start_next);
    TextView activityName = findViewById(R.id.textView_start_message);

    nextPageButton.setOnClickListener(view -> {
      Intent intent = new Intent(getApplicationContext(),MainActivity.class);
      startActivity(intent);
    });

    viewPager.setAdapter(new adapter(getSupportFragmentManager()));

    activityName.setText(SEASON_TITLE);
  }

  private class adapter extends FragmentPagerAdapter {
    adapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      return presenter.seasonFragmentGetItem(position,MAX_PAGE);
    }

    @Override
    public int getCount() {
      return MAX_PAGE;
    }
  }
}
