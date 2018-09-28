package com.bbkk.android.bbkkclient.view.write;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.WritePresenter;
import com.bumptech.glide.request.RequestOptions;
import com.erikagtierrez.multiple_media_picker.Gallery;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.SliderTypes.BaseSliderView;
import com.glide.slider.library.SliderTypes.TextSliderView;
import com.glide.slider.library.Tricks.ViewPagerEx;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WriteActivity extends AppCompatActivity implements WriteContract.View,
  BaseSliderView.OnSliderClickListener,
  ViewPagerEx.OnPageChangeListener {
  private static final String IMAGE_PICKER_TITLE = "title";
  private static final String IMAGE_PICKER_VALUE = "이미지 선택";
  private static final int OPEN_MEDIA_PICKER = 1;
  private static final String MAX_IMAGE_PICK_TITLE = "maxSelection";
  private static final int MAX_IMAGE_PICK_VALUE = 5;
  private ArrayList<String> selectImages;
  private WriteContract.Presenter presenter;
  @BindView(R.id.tv_header_cancel)
  public TextView tvCancelBtn;
  @BindView(R.id.tv_header_next)
  public TextView tvNextBtn;
  @BindView(R.id.sl_write_images)
  public SliderLayout slImageSlider;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_write);
    ButterKnife.bind(this);
    presenter = new WritePresenter(this);
  }

  @Override
  public void initView() {
    this.listenCancel();
    this.listenSubmit();
    this.setPermission();
  }

  private void listenSubmit() {
    tvNextBtn.setOnClickListener((__) -> {
      presenter.RegisterContentList();
    });
  }

  private void listenCancel() {
    tvCancelBtn.setOnClickListener((__) -> {

      finish();
    });
  }

  private void setPermission() {
    PermissionListener permissionlistener = new PermissionListener() {
      @Override
      public void onPermissionGranted() {
        initImagePicker();
      }

      @Override
      public void onPermissionDenied(List<String> deniedPermissions) {
        finish();
        Toast.makeText(WriteActivity.this, "권한이 없어 내용 등록이 불가능합니다.", Toast.LENGTH_SHORT).show();
      }
    };

    new TedPermission().with(getApplicationContext())
      .setPermissionListener(permissionlistener)
      .setDeniedMessage("권한 설정 동의를 안하신다면, 나중에 이곳에서 설정해 주세요. [설정] > [권한]")
      .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
      .check();
  }

  private void initImagePicker() {
    Intent intent= new Intent(this, Gallery.class);
    intent.putExtra(IMAGE_PICKER_TITLE, IMAGE_PICKER_VALUE);
    intent.putExtra("mode", 2);
    intent.putExtra(MAX_IMAGE_PICK_TITLE, MAX_IMAGE_PICK_VALUE);
    startActivityForResult(intent, OPEN_MEDIA_PICKER);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == OPEN_MEDIA_PICKER) {
      if (resultCode == RESULT_OK && data != null) {
        ArrayList<String> selectionResult = data.getStringArrayListExtra("result");
        renderWriteImageView(selectionResult);
      } else {
        finish();
      }
    }
  }

  private void renderWriteImageView(ArrayList<String> selectionResult) {
    selectImages = selectionResult;
    RequestOptions requestOptions = new RequestOptions();
    requestOptions.centerCrop();

    for(int index = 0; index < selectImages.size(); index++ ) {
      TextSliderView sliderView = new TextSliderView(this);

      sliderView.image(selectImages.get(index))
        .setRequestOption(requestOptions)
        .setBackgroundColor(Color.WHITE)
        .setProgressBarVisible(true)
        .setOnSliderClickListener(this);

      slImageSlider.addSlider(sliderView);
    }

    slImageSlider.setPresetTransformer(SliderLayout.Transformer.Default);
    slImageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
    slImageSlider.setDuration(4000);
    slImageSlider.addOnPageChangeListener(this);
  }

  @Override
  public void onSliderClick(BaseSliderView baseSliderView) {
  }

  @Override
  public void onPageScrolled(int i, float v, int i1) {
  }

  @Override
  public void onPageSelected(int i) {
  }

  @Override
  public void onPageScrollStateChanged(int i) {
  }
}
