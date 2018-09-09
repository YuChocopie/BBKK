package com.bbkk.android.bbkkclient.view.nameSetting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.view.tendency.TendencyActivity;

public class NameActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_name);

    ImageButton startButton = findViewById(R.id.btn_name_start);

    startButton.setOnClickListener(view -> {
      Intent intent = new Intent(getApplicationContext(),TendencyActivity.class);
      startActivity(intent);
    });

  }

}
