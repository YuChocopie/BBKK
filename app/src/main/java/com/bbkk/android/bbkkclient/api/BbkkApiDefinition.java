package com.bbkk.android.bbkkclient.api;

import com.bbkk.android.bbkkclient.model.NameModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BbkkApiDefinition {
  String BASE_URL = "http://106.10.50.31:8080";

  @GET("/v1/generate/nickname")
  Call<NameModel> getRandomName();

  Retrofit retrofit = new Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build();
}
