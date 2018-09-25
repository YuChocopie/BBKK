package com.bbkk.android.bbkkclient.presenter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bbkk.android.bbkkclient.api.BbkkApiDefinition;
import com.bbkk.android.bbkkclient.model.MainModel;
import com.bbkk.android.bbkkclient.model.TimelineEntry;
import com.bbkk.android.bbkkclient.view.main.MainContract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;


public class MainPresenter implements MainContract.Presenter {

  private MainContract.View view;
  private MainModel mainModel;
  public TimelineEntry timelineResponseBody;
  public TimelineEntry timelineEntries;
  public ArrayList<TimelineEntry> timelines = new ArrayList<>();


  public MainPresenter(MainContract.View mainView) {
    this.view = mainView;
    this.mainModel = new MainModel();
    view.initView();
    this.TimeLineRetrofit();
    this.requestContentList();
  }

  public void TimeLineRetrofit() {

//
  }

  private void requestContentList() {
//    TODO: 서버에 요청한다.
    BbkkApiDefinition bbkkApiDefinition = BbkkApiDefinition.retrofit.create(BbkkApiDefinition.class);
    Call<TimelineEntry> call = bbkkApiDefinition.getTimeLine(0,10,true,3);
    call.enqueue(new Callback<TimelineEntry>() {
      @Override
      public void onResponse(Call<TimelineEntry> call, Response<TimelineEntry> response) {
        if(response.isSuccessful()){
          timelineResponseBody = response.body();
          Log.d(TAG,"response.raw :"+response.raw());
          if(response.body().getCode().equals(200)){ // 200 = 성공
            Log.e("토탈사이즈", String.valueOf(response.body().getResult().getTotal_size()));
            Log.e("토탈사이즈", String.valueOf(response.body().getResult().getPopular_data().get(0)));
            Log.e("다이틀", String.valueOf(response.body().result.popular_data.get(0).title));
            Log.e("꿀", String.valueOf(response.body().result.popular_data.get(0).honey_count));
            ArrayList<TimelineEntry> timelines = new ArrayList<>();
            Log.e("!111111","시작3333");
            for (int i= 0 ; i<response.body().getResult().getTotal_size();i++) {
//              timelines.add (
//                new TimelineEntry.result.popular_data(
//                  timelineResponseBody.result.popular_data.get(i).feed_id,
//                  timelineResponseBody.result.popular_data.get(i).honey_count,
//                  timelineResponseBody.result.popular_data.get(i).title,
//                  timelineResponseBody.result.popular_data.get(i).subtitle,
//                  timelineResponseBody.result.popular_data.get(i).local_content,
//                  timelineResponseBody.result.popular_data.get(i).image_url,
//                  timelineResponseBody.result.popular_data.get(i).create_at
//                ));
            }
            view.renderTimeLine(timelines);
            view.renderMainCounter(timelineResponseBody.getResult().getTotal_size());
          }else{
            Log.e(TAG,"요청 실패 :"+timelineEntries.getCode());
            Log.e(TAG,"메시지 :"+timelineEntries.getMsg());
          }
        }
      }

      @Override
      public void onFailure(Call<TimelineEntry> call, Throwable t) {
        Log.e("onFailure","Call TimelineEntry Fail");
      }
    });
//    timelineEntries.add(new TimelineEntry("1","하이1"));
//    timelineEntries.add(new TimelineEntry("2","하이2"));
//    timelineEntries.add(new TimelineEntry("3","하이3"));
//    timelineEntries.add(new TimelineEntry("4","하이4"));
//    Log.e("에에아아아ㅏㅇ", String.valueOf(TimelineEntry.result.total_size));
    view.renderTimeLine(timelines);
  }
}
