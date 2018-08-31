package com.bbkk.android.bbkkclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SeasonActivity extends AppCompatActivity {

  private static final String SEASON_TITLE = "Season";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_season);

    ImageButton nextPageButton = findViewById(R.id.btn_start_next);

    nextPageButton.setOnClickListener(view -> {
      Intent intent = new Intent(getApplicationContext(),MainActivity.class);
      startActivity(intent);
    });

  TextView activityName = findViewById(R.id.textView_start_message);
  activityName.setText(SEASON_TITLE);

  }
}
