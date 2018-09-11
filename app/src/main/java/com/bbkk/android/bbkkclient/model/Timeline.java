package com.bbkk.android.bbkkclient.model;

public class Timeline {
  public String name;
  public Integer image;
  public Timeline(Integer image, String name) {
    this.image = image;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getImage() {
    return image;
  }

  public void setImage(Integer image) {
    this.image = image;
  }
}

