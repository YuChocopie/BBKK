package com.bbkk.android.bbkkclient.view.main;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View{
  private MainContract.Presenter presenter;

  @BindView(R.id.drawer_layout)
  public DrawerLayout drawer;
  @BindView(R.id.iv_menu_button)
  public ImageView btnOpenMenu;
  @BindView(R.id.nv_header_main)
  public NavigationView nvHeaderMain;
  @BindView(R.id.btn_start_write)
  public FloatingActionButton btnWrite;
  private View headerView;
  private ImageView ivCloseMenu;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    presenter = new MainPresenter(this);
  }

  @Override
  public void initView() {
    headerView = nvHeaderMain.getHeaderView(0);
    ivCloseMenu = headerView.findViewById(R.id.iv_close_button);
    this.drawerManager();
    this.writeListener();
  }

  private void writeListener() {
    btnWrite.setOnClickListener((__) -> {
      startWriteActivity();
    });
  }

  private void startWriteActivity() {
//    TODO: writeActivity 실행
  }

  private void drawerManager() {
    this.openHeaderMenu();
    this.closeHeaderMenu();
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
