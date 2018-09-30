package com.bbkk.android.bbkkclient.api;

import com.bbkk.android.bbkkclient.model.request.FeedRequest;
import com.bbkk.android.bbkkclient.model.request.TypeRequest;
import com.bbkk.android.bbkkclient.model.response.CardFeedsResponse;
import com.bbkk.android.bbkkclient.model.response.FeedResponse;
import com.bbkk.android.bbkkclient.model.response.NameResponse;
import com.bbkk.android.bbkkclient.model.response.TypeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface BbkkApiDefinition {
  @GET("/v1/generate/nickname")
  Call<NameResponse> getRandomName();

  @GET("/v1/playland/feed?size=200")
  Call<CardFeedsResponse> getCardFeeds();

  @POST("/v1/traveler/register")
  Call<TypeResponse> postTypeRegister(
    @Body
    TypeRequest typeRequest
  );

  @POST("/v1/playland/register")
  Call<FeedResponse> postFeed(
    @Body
    FeedRequest feedRequest
  );
}
