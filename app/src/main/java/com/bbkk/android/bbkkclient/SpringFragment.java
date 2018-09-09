package com.bbkk.android.bbkkclient;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SpringFragment extends android.support.v4.app.Fragment {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
  @SuppressLint("ResourceAsColor")
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.item_season_viewpager,container,false);
    LinearLayout background=(LinearLayout)linearLayout.findViewById(R.id.fragment_page);
    TextView page_num=(TextView)linearLayout.findViewById(R.id.season_page_num);
    page_num.setText("Spring");
    background.setBackground(new ColorDrawable(R.color.black5));
    return linearLayout;
  }
}