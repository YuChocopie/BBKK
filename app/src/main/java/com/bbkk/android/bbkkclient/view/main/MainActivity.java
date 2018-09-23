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
import com.bbkk.android.bbkkclient.presenter.MainPresenter;
import com.bbkk.android.bbkkclient.presenter.TimeLineAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View{

  private RecyclerView mRecyclerView;
  private static final String MAIN_TITLE = "서울의 여름";
  private MainContract.Presenter presenter;
  private TextView activityName;
  private FloatingActionButton fabStartWrite;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//    presenter();
  }

  private void presenter() {
//    mRecyclerView = findViewById(R.id.timeline_recycler_view);
//    presenter = new MainPresenter(this);
//    presenter.callRecyclerView(mRecyclerView);
  }

  @Override
  public void initView() {
//    activityName = findViewById(R.id.textView_global_header);
//    fabStartWrite = findViewById(R.id.btn_start_write);
//    activityName.setText(MAIN_TITLE);
//    fabStartWrite.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//      .setAction("Action", null).show());
  }
}
