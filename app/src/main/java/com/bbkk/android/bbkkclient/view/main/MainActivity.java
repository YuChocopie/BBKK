package com.bbkk.android.bbkkclient.view.main;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.model.Timeline;
import com.bbkk.android.bbkkclient.presenter.TimeLineAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  RecyclerView mRecyclerView;
  private static final String MAIN_TITLE = "서울의 여름";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView activityName = findViewById(R.id.textView_global_header);
    activityName.setText(MAIN_TITLE);

    FloatingActionButton fab = findViewById(R.id.btn_start_write);
    fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
      .setAction("Action", null).show());

    mRecyclerView = findViewById(R.id.timeline_recycler_view);
    mRecyclerView.setHasFixedSize(true);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(layoutManager);
    ArrayList<Timeline> timelineArrayList = new ArrayList<>();

    timelineArrayList.add(new Timeline(R.drawable.choice,"남한산성"));
    timelineArrayList.add(new Timeline(R.drawable.choice,"백두산"));
    timelineArrayList.add(new Timeline(R.drawable.choice,"가을음악회"));
    timelineArrayList.add(new Timeline(R.drawable.choice,"유정이와함께 한강 자전거"));

    TimeLineAdapter timeLineAdapter = new TimeLineAdapter(timelineArrayList);

    mRecyclerView.setAdapter(timeLineAdapter);
  }
}
