package com.bbkk.android.bbkkclient.view.tendency;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.TendencyPresenter;
import com.bbkk.android.bbkkclient.view.season.SeasonActivity;

public class TendencyActivity extends AppCompatActivity implements TendencyContract.View {

  private static final String TENDENCY_TITLE = "TENDENCY";
  private int MAX_PAGE=5;
  ViewPager vpTendency;
  TendencyContract.Presenter presenter;
  ImageButton ibtnNext;
  TextView tvTendencyName;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tendency);
    presenter();
  }

  private void presenter() {
    presenter = new TendencyPresenter(this);
  }

  @Override
  public void initView() {
    vpTendency = findViewById(R.id.season_viewpager);
    ibtnNext = findViewById(R.id.btn_start_next);
    tvTendencyName = findViewById(R.id.textView_start_message);

    ibtnNext.setOnClickListener(view -> {
      Intent intent = new Intent(getApplicationContext(), SeasonActivity.class);
      startActivity(intent);
    });

    vpTendency.setAdapter(new adapter(getSupportFragmentManager()));
    tvTendencyName.setText(TENDENCY_TITLE);
  }

  private class adapter extends FragmentPagerAdapter {
    public adapter(FragmentManager fm) {
      super(fm);
    }
    @Override
    public Fragment getItem(int position) {
      return presenter.tendencyFragmentGetItem(position,MAX_PAGE);
    }
    @Override
    public int getCount() {
      return MAX_PAGE;
    }
  }

}
