package com.bbkk.android.bbkkclient.api;

import com.bbkk.android.bbkkclient.model.response.NameResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface BbkkApiDefinition {
  @GET("/v1/generate/nickname")
  Call<NameResponse> getRandomName();
}
