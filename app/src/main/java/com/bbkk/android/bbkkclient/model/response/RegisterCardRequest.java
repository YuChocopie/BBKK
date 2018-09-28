package com.bbkk.android.bbkkclient.model.response;

import java.util.HashMap;

public class RegisterCardRequest {
  public int traveler_id;
  public String title;
  public String category;
  //  enum(SPRING,SUMMER,AUTUMN,WINTER)
  public String season;
  public String content;
  public String position;
  public String images;

  public RegisterCardRequest(HashMap<String,Object> parameters) {
    this.traveler_id = (int) parameters.get("traveler_id");
    this.title = (String) parameters.get("title");
    this.category = (String) parameters.get("category");
    this.season = (String) parameters.get("season");
    this.content = (String) parameters.get("content");
    this.position = (String) parameters.get("position");
    this.images = (String) parameters.get("images");
  }

  //  public RegisterCardRequest(
//    int traveler_id,
//     String title,
//     String category,
//     String season,
//      String content,
//     String position,
//    String images) {
//    this.traveler_id =traveler_id;
//    this.title = title;
//    this.category  = category;
//    this.season = season;
//    this.content= content;
//    this.position = position;
//    this.images = images;
//  }
}
