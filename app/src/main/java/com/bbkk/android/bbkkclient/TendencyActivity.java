package com.bbkk.android.bbkkclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class TendencyActivity extends AppCompatActivity {

  private static final String TENDENCY_TITLE = "TENDENCY";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tendency);

    ImageButton nextPageButton = findViewById(R.id.btn_start_next);

    nextPageButton.setOnClickListener(view -> {
      Intent intent = new Intent(getApplicationContext(), SeasonActivity.class);
      startActivity(intent);
    });

    TextView activityName = findViewById(R.id.textView_start_message);
    activityName.setText(TENDENCY_TITLE);
  }
}
