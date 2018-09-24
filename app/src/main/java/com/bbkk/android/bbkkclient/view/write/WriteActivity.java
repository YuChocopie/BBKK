package com.bbkk.android.bbkkclient.view.write;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.WritePresenter;

import butterknife.BindView;

public class WriteActivity extends AppCompatActivity implements WriteContract.View {
  private WriteContract.Presenter presenter;
  @BindView(R.id.tv_header_cancel)
  public TextView tvCancelBtn;
  @BindView(R.id.tv_header_next)
  public TextView tvNextBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_write);
    presenter = new WritePresenter(this);
  }

  @Override
  public void initView() {
    this.listenCancel();
    this.listenSubmit();
  }

  private void listenSubmit() {
    tvNextBtn.setOnClickListener((__) -> {

    });
  }

  private void listenCancel() {
    tvCancelBtn.setOnClickListener((__) -> {
      finish();
    });
  }
}
