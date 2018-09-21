package com.bbkk.android.bbkkclient.view.tendency;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;

public class TendencyFragment_niggard extends android.support.v4.app.Fragment {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
  @SuppressLint("ResourceAsColor")
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.item_tendency_viewpager,container,false);
    LinearLayout background= linearLayout.findViewById(R.id.fragment_page);
    TextView page_num= linearLayout.findViewById(R.id.tendency_page_num);
    page_num.setText("44");
    background.setBackground(new ColorDrawable(R.color.spring));
    return linearLayout;
  }
}
