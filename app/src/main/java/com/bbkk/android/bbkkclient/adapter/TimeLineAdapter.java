package com.bbkk.android.bbkkclient.adapter;

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
import com.bbkk.android.bbkkclient.model.TimelineEntry;
import com.bbkk.android.bbkkclient.view.detail.DetailActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder> {

  private ArrayList<TimelineEntry.result.popular_data> popular_data;
  private TimelineEntry timelineEntry;
  private ArrayList<TimelineEntry> timelineEntries;
  private Context context;
  private final View.OnClickListener onClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//    TODO: 터치에 나 오는 getAdapterPosition() 값을 가지고 switch 문을 이용해 Intent를 구분지어 준다)
      final Intent intent;
      intent = new Intent(context, DetailActivity.class);
      context.startActivity(intent);
    }
  };

  public TimeLineAdapter(ArrayList<TimelineEntry> timelineEntries) {
    this.timelineEntries = timelineEntries;
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
//    TimelineEntry.Result.popular_data entries = this.timelineEntries.get(position);
//
//    holder.ivImage.setImageResource(Integer.parseInt(entries.image_url));
//    holder.tvHoneyCount.setText(entries.honey_count);
//    holder.tvTitle.setText(entries.title);
//    holder.tvSubTitle.setText(entries.subtitle);
//    holder.tvLocalContent.setText(entries.local_content);
//
//    TimeLineViewHolder timeLineViewHolder = holder;

//    timeLineViewHolder.ivImage.setImageResource(items.get(position).);
//    timeLineViewHolder.timeLineimage.setImageResource(items.get(position).image);
  }

  @Override
  public int getItemCount() {
//    Log.e("getgetget", String.valueOf(timelineEntry.result.total_size));
//    return TimelineEntry.Result(g)
//      popular_data.size();
//      timelineEntries< TimelineEntry.Result.size();
//    아 왜안돼,,ㅡㅡ
//    return timelineEntries.size();
    return 4;
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
