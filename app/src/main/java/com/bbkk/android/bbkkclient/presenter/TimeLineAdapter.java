package com.bbkk.android.bbkkclient.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbkk.android.bbkkclient.R;
import com.bbkk.android.bbkkclient.model.Timeline;
import com.bbkk.android.bbkkclient.view.detail.DetailActivity;

import java.util.ArrayList;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder> {

  private ArrayList<Timeline> items;
  private Context context;
  private final View.OnClickListener onClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//    TODO: 터치에 나오는 getAdapterPosition() 값을 가지고 switch 문을 이용해 Intent를 구분지어 준다)
      final Intent intent;
      intent = new Intent(context, DetailActivity.class);
      context.startActivity(intent);
    }
  };

  public TimeLineAdapter(ArrayList<Timeline> data) {
    this.items = data;

  }

  @NonNull
  @Override
  public TimeLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.item_timeline, parent, false);
    view.setOnClickListener(onClickListener);
    return new TimeLineViewHolder(view);
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

  public class TimeLineViewHolder extends RecyclerView.ViewHolder {
    ImageView ivImage;
    TextView tvHoneyCount;
    TextView tvTitle;
    TextView tvSubTitle;
    TextView tvLocalContent;

    public TimeLineViewHolder (View view) {
      super(view);
      context = view.getContext();
      ivImage = view.findViewById(R.id.iv_timeline_image);
      tvHoneyCount = view.findViewById(R.id.tv_honey_count);
      tvTitle = view.findViewById(R.id.tv_timeline_title);
      tvSubTitle = view.findViewById(R.id.tv_timeline_subtitle);
      tvLocalContent = view.findViewById(R.id.tv_timeline_local_content);
    }
  }
}
