package com.bbkk.android.bbkkclient.view.nameSetting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.NamePresenter;
import com.bbkk.android.bbkkclient.view.tendency.TendencyActivity;

public class NameActivity extends Activity implements NameContract.View{

  private TextView tvRandomname;
  private ImageButton btnChangeName;
  private ImageButton btnStart;
  NameContract.Presenter presenter;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_name);
    presenter();
  }
  private void presenter() {
    presenter = new NamePresenter(this);
  }

  public void initView() {
    tvRandomname = findViewById(R.id.editText_random_name);
    btnChangeName = findViewById(R.id.btn_name_change);
    btnStart = findViewById(R.id.btn_name_start);
    btnStart.setOnClickListener(view -> {
      Intent intent = new Intent(getApplicationContext(),TendencyActivity.class);
      startActivity(intent);
    });
  }

  @Override
  public void showRandomName(String name) {
    tvRandomname.setText(name);
  }
}
