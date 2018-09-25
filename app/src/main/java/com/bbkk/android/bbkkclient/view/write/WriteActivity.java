package com.bbkk.android.bbkkclient.view.write;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.presenter.WritePresenter;
import com.erikagtierrez.multiple_media_picker.Gallery;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WriteActivity extends AppCompatActivity implements WriteContract.View {
  private static final String IMAGE_PICKER_TITLE = "title";
  private static final String IMAGE_PICKER_VALUE = "이미지 선택";
  private static final int OPEN_MEDIA_PICKER = 1;
  private static final String MAX_IMAGE_PICK_TITLE = "maxSelection";
  private static final int MAX_IMAGE_PICK_VALUE = 5;
  private WriteContract.Presenter presenter;
  @BindView(R.id.tv_header_cancel)
  public TextView tvCancelBtn;
  @BindView(R.id.tv_header_next)
  public TextView tvNextBtn;

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
    ArrayList<String> currentImageResult = selectionResult;
    Log.e("픽픽", String.valueOf(currentImageResult));
  }
}
