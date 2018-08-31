package com.bbkk.android.bbkkclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class TendencyActivity extends AppCompatActivity implements ViewFlipperAction.ViewFlipperCallback{

  private static final String TENDENCY_TITLE = "TENDENCY";

  ViewFlipper flipper;
  List<ImageView> indexes;
  private int position;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tendency);

    tendencyFlipper();

    ImageButton nextPageButton = findViewById(R.id.btn_start_next);

    nextPageButton.setOnClickListener(view -> {
      Intent intent = new Intent(getApplicationContext(), SeasonActivity.class);
      startActivity(intent);
    });

    TextView activityName = findViewById(R.id.textView_start_message);
    activityName.setText(TENDENCY_TITLE);
  }

  private void tendencyFlipper() {
    flipper = findViewById(R.id.flipper_tendency);
    ImageView index0 = findViewById(R.id.imageView_tendency_imgIndex0);
    ImageView index1 = findViewById(R.id.imageView_tendency_imgIndex1);
    ImageView index2 = findViewById(R.id.imageView_tendency_imgIndex2);
    ImageView index3 = findViewById(R.id.imageView_tendency_imgIndex3);
    ImageView index4 = findViewById(R.id.imageView_tendency_imgIndex4);

    //인덱스리스트
    indexes = new ArrayList<>();
    indexes.add(index0);
    indexes.add(index1);
    indexes.add(index2);
    indexes.add(index3);
    indexes.add(index4);

    //xml을 inflate 하여 flipper view에 추가하기
    LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    View view1 = inflater.inflate(R.layout.item_tendency_view_flipper1, flipper, false);
    View view2 = inflater.inflate(R.layout.item_tendency_view_flipper2, flipper, false);
    View view3 = inflater.inflate(R.layout.item_tendency_view_flipper3, flipper, false);
    View view4 = inflater.inflate(R.layout.item_tendency_view_flipper4, flipper, false);
    View view5 = inflater.inflate(R.layout.item_tendency_view_flipper5, flipper, false);
    //inflate 한 view 추가
    flipper.addView(view1);
    flipper.addView(view2);
    flipper.addView(view3);
    flipper.addView(view4);
    flipper.addView(view5);
    //리스너설정 - 좌우 터치시 화면넘어가기
    flipper.setOnTouchListener(new ViewFlipperAction(this, flipper));
  }

  //인덱스 업데이트
  @Override
  public void onFlipperActionCallback(int position) {
    this.position = position;
    Log.d("ddd", "" + position);
    for (int i = 0; i < indexes.size(); i++) {
      ImageView index = indexes.get(i);
      //현재화면의 인덱스 위치면 녹색
      if (i == position) {
        index.setImageResource(R.drawable.choice);
      }
      //그외
      else {
        index.setImageResource(R.drawable.not_choice);
      }
    }
  }
}
