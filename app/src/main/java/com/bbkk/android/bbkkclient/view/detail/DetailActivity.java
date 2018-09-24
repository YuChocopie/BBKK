package com.bbkk.android.bbkkclient.view.detail;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
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
import com.bbkk.android.bbkkclient.view.review.ReviewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {
  private DetailContract.Presenter presenter;
  private Boolean hasLike = false;

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
  @BindView(R.id.iv_like_button)
  public ImageView ivLikeBtn;
  @BindView(R.id.cl_review_button)
  public ConstraintLayout clReviewBtn;

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
    this.detailManager();
    this.reviewBtnListener();
  }

  private void reviewBtnListener() {
    clReviewBtn.setOnClickListener((__) -> {
      startActivity(new Intent(this, ReviewActivity.class));
    });
  }

  private void detailManager() {
    this.renderLike(hasLike);
    this.likeListener();
  }

  private void renderLike(Boolean hasLike) {
    Boolean currentHasLike = hasLike;
    if (currentHasLike) {
      ivLikeBtn.setBackgroundResource(R.color.red1);
    } else {
      ivLikeBtn.setBackgroundResource(R.color.gray1);
    }
    this.hasLike = !currentHasLike;
//    TODO: hasLike 값을 서버에 전송한다.
  }

  private void likeListener() {
    ivLikeBtn.setOnClickListener((__) -> {
      renderLike(hasLike);
    });
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
