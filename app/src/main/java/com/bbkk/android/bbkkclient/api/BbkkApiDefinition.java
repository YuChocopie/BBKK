package com.bbkk.android.bbkkclient.api;

import com.bbkk.android.bbkkclient.model.response.CardFeedsResponse;
import com.bbkk.android.bbkkclient.model.response.NameResponse;
import com.bbkk.android.bbkkclient.model.response.RegisterCardRequest;
import com.bbkk.android.bbkkclient.model.response.RegisterCardResponse;
import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface BbkkApiDefinition {
  @GET("/v1/generate/nickname")
  Call<NameResponse> getRandomName();

  @GET("/v1/playland/feed")
  Call<CardFeedsResponse> getCardFeeds();

//  @FormUrlEncoded
  @POST("/v1/playland/register")
  Call<RegisterCardResponse> postRegisterCard(
    @Body HashMap<String, Object> registerCardRequest);
//    @Field("traveler_id") Integer traveler_id,
//    @Field("title") String title,
//    @Field("category") String category,
//    @Field("season") String season,
//    @Field("content") String content,
//    @Field("position") String position,
//    @Field("images") String images
//  );
}
