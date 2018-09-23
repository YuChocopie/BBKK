package com.bbkk.android.bbkkclient.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.model.Timeline;

import java.util.ArrayList;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

  private ArrayList<Timeline> items;
  public TimeLineAdapter(ArrayList<Timeline> data){
    this.items = data;
  }

  @NonNull
  @Override
  public TimeLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.item_timeline, parent, false);
    return new TimeLineViewHolder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull TimeLineViewHolder holder, int position) {
//    TimeLineViewHolder timeLineViewHolder = holder;
//
//    timeLineViewHolder.timeLineName.setText(items.get(position).name);
//    timeLineViewHolder.timeLineimage.setImageResource(items.get(position).image);
  }

  @Override
  public int getItemCount() {
    return items.size();
  }
}
