package com.bbkk.android.bbkkclient.view.review;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;

import butterknife.BindView;

public class WriteReviewActivity extends AppCompatActivity {

  @BindView(R.id.tv_back_button)
  public TextView btnBack;
  @BindView(R.id.tv_review_write_check)
  public TextView btnWriteCheck;
  @BindView(R.id.tv_write_review_name)
  public TextView tvWriterName;
  @BindView(R.id.tv_write_review)
  public TextView tvWriteReview;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_write_review);
    closeActivity();
  }

  private void closeActivity() {
    btnBack.setOnClickListener((__) -> finish());
  }
  private void WriteCheck() {
    btnWriteCheck.setOnClickListener((__) -> {

    });
  }

}
