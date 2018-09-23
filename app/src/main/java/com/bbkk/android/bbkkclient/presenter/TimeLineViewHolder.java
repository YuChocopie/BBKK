package com.bbkk.android.bbkkclient.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;

public class TimeLineViewHolder extends RecyclerView.ViewHolder {

  ImageView ivImage;
  TextView tvHoneyCount;
  TextView tvTitle;
  TextView tvSubTitle;
  TextView tvLocalContent;

  TimeLineViewHolder (View view) {
    super(view);
    ivImage = view.findViewById(R.id.iv_timeline_image);
    tvHoneyCount = view.findViewById(R.id.tv_honey_count);
    tvTitle = view.findViewById(R.id.tv_timeline_title);
    tvSubTitle = view.findViewById(R.id.tv_timeline_subtitle);
    tvLocalContent = view.findViewById(R.id.tv_timeline_local_content);
  }

}
