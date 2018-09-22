package com.bbkk.android.bbkkclient.view.nameSetting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.NamePresenter;
import com.bbkk.android.bbkkclient.view.tendency.TendencyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NameActivity extends Activity implements NameContract.View{

  @BindView(R.id.tv_name_result)
  public TextView tvNameResult;

  @BindView(R.id.iv_change_button)
  public ImageView ivChangeName;

  @BindView(R.id.btn_name_submit)
  public Button btnNameSubmit;

  NameContract.Presenter presenter;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new NamePresenter(this);
  }

  @Override
  public void initView() {
    setContentView(R.layout.activity_name);
    ButterKnife.bind(this);
    this.renderView();
  }

  @Override
  public void startTendencyActivity() {
    startActivity(new Intent(this, TendencyActivity.class));
    finish();
  }

  @Override
  public void renderChangeName(String currentName) {
    tvNameResult.setText(currentName);
  }

  private void renderView() {
    this.changeNameListener();
    this.submitButtonListener();
  }

  private void changeNameListener() {
    ivChangeName.setOnClickListener((__) -> {
      presenter.changeNameAction();
    });
  }

  private void submitButtonListener() {
    btnNameSubmit.setOnClickListener((__) -> {
      presenter.submitAction();
    });
  }
}
