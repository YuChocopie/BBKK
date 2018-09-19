package com.bbkk.android.bbkkclient.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;

public class TimeLineViewHolder extends RecyclerView.ViewHolder {

  TextView timeLineName;
  ImageView timeLineimage;


  TimeLineViewHolder (View itemView) {
    super(itemView);
    timeLineName = itemView.findViewById(R.id.textView_timeline_name);
    timeLineimage = itemView.findViewById(R.id.imageView_timeline_honey_image);
  }

}
