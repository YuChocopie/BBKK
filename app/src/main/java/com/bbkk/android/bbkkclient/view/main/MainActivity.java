package com.bbkk.android.bbkkclient.view.main;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;

public class MainActivity extends AppCompatActivity {
  private static final String MAIN_TITLE = "서울의 여름";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView activityName = findViewById(R.id.textView_global_header);
    activityName.setText(MAIN_TITLE);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btn_start_write);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          .setAction("Action", null).show();
      }
    });
  }
}
