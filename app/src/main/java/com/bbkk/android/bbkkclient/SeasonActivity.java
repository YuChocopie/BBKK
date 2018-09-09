package com.bbkk.android.bbkkclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

public class SeasonActivity extends AppCompatActivity {

  private static final String SEASON_TITLE = "Season";
  int MAX_PAGE=4;
  Fragment fragment = new Fragment();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_season);

    ViewPager viewPager = findViewById(R.id.season_viewpager);
    viewPager.setAdapter(new adapter(getSupportFragmentManager()));

    ImageButton nextPageButton = findViewById(R.id.btn_start_next);

    nextPageButton.setOnClickListener(view -> {
      Intent intent = new Intent(getApplicationContext(),MainActivity.class);
      startActivity(intent);
    });

  TextView activityName = findViewById(R.id.textView_start_message);
  activityName.setText(SEASON_TITLE);

  }

  private class adapter extends FragmentPagerAdapter {
    public adapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      if(position<0 || MAX_PAGE<=position)
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

    @Override
    public int getCount() {
      return MAX_PAGE;
    }
  }
}
