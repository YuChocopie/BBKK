package com.bbkk.android.bbkkclient.view.detail;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.DetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {
  private DetailContract.Presenter presenter;

  @BindView(R.id.tv_back_button)
  public TextView tvBackBtn;
  @BindView(R.id.drawer_layout)
  public DrawerLayout drawer;
  @BindView(R.id.iv_menu_button)
  public ImageView btnOpenMenu;
  @BindView(R.id.nv_header_main)
  public NavigationView nvHeaderMain;
  private View headerView;
  private ImageView ivCloseMenu;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    ButterKnife.bind(this);
    this.presenter = new DetailPresenter(this);
  }

  @Override
  public void onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public void initView() {
    headerView = nvHeaderMain.getHeaderView(0);
    ivCloseMenu = headerView.findViewById(R.id.iv_close_button);
    this.drawerManager();

  }

  private void drawerManager() {
    this.closeActivity();
    this.openHeaderMenu();
    this.closeHeaderMenu();
  }

  private void closeActivity() {
    tvBackBtn.setOnClickListener((__) -> {
      finish();
    });
  }

  private void closeHeaderMenu() {
    ivCloseMenu.setOnClickListener((__) -> {
      drawer.closeDrawer(GravityCompat.START);
    });
  }

  private void openHeaderMenu() {
    btnOpenMenu.setOnClickListener((__) -> {
      drawer.openDrawer(GravityCompat.START);
    });
  }
}
