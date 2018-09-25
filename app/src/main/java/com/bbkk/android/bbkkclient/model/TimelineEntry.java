package com.bbkk.android.bbkkclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class TimelineEntry {
  @SerializedName("code") Integer code;
  @SerializedName("msg")  String  msg;
  public @SerializedName("result") result result;

  public class result {
    public List<popular_data> popular_data;
    @SerializedName("next_cursor") public Integer next_cursor;
    @SerializedName("total_size") public Integer total_size;

    public Integer getNext_cursor() {
      return next_cursor;
    }

    public Integer getTotal_size() {
      return total_size;
    }


    public void setNext_cursor(Integer next_cursor) {
      this.next_cursor = next_cursor;
    }

    public void setTotal_size(Integer total_size) {
      this.total_size = total_size;
    }

    public List<popular_data> getPopular_data()
    {
      return popular_data;
    }
    public class popular_data extends TimelineEntry {
      @SerializedName("id") public Integer feed_id;
      @SerializedName("title") public String title;
      @SerializedName("season") public String season;
      @SerializedName("content") public String subtitle;
      @SerializedName("position") public String local_content;
      @SerializedName("image_url") public String image_url;
      @SerializedName("traveler") public Traveler traveler;
      @SerializedName("like_cnt") public Integer honey_count;
      @SerializedName("create_at") public String create_at;
    public popular_data(
      Integer feed_id,
      Integer honey_count,
      String title,
      String subtitle,
      String local_content,
      String season,
      String image_url,
      String create_at){
      this.feed_id = feed_id;
      this.image_url = image_url;
      this.honey_count = honey_count;
      this.title = title;
      this.subtitle = subtitle;
      this.local_content = local_content;
      this.season = season;
      this.create_at = create_at;
    }

      public popular_data(Integer feed_id, Integer honey_count, String title, String subtitle, String local_content, String image_url, String create_at
      ) {
        this.feed_id = feed_id;
        this.image_url = image_url;
        this.honey_count = honey_count;
        this.title = title;
        this.subtitle = subtitle;
        this.local_content = local_content;
        this.season = season;
        this.create_at = create_at;
      }

      public void getInstance() {
        return ;
      }
      public Integer getFeed_id() {
        return feed_id;
      }

      public String getTitle() {
        return title;
      }

      public String getSeason() {
        return season;
      }

      public String getSubtitle() {
        return subtitle;
      }

      public String getLocal_content() {
        return local_content;
      }

      public String getImage_url() {
        return image_url;
      }

      public Integer getHoney_count() {
        return honey_count;
      }

      public String getCreate_at() {
        return create_at;
      }

      public void setFeed_id(Integer feed_id) {
        this.feed_id = feed_id;
      }

      public void setCreate_at(String create_at) {
        this.create_at = create_at;
      }

      public void setHoney_count(Integer honey_count) {
        this.honey_count = honey_count;
      }

      public void setImage_url(String image_url) {
        this.image_url = image_url;
      }

      public void setLocal_content(String local_content) {
        this.local_content = local_content;
      }

      public void setSeason(String season) {
        this.season = season;
      }

      public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
      }

      public void setTitle(String title) {
        this.title = title;
      }

      public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
      }

      public class Traveler {
        @SerializedName("id") public Integer traveler_id;
        @SerializedName("nickname") public String traveler_nickname;
        @SerializedName("property") public String traveler_property;

        public Integer getTraveler_id() {
          return traveler_id;
        }

        public String getTraveler_nickname() {
          return traveler_nickname;
        }

        public String getTraveler_property() {
          return traveler_property;
        }

        public void setTraveler_id(Integer traveler_id) {
          this.traveler_id = traveler_id;
        }

        public void setTraveler_nickname(String traveler_nickname) {
          this.traveler_nickname = traveler_nickname;
        }

        public void setTraveler_property(String traveler_property) {
          this.traveler_property = traveler_property;
        }
      }

      public Traveler getTraveler() {
        return traveler;
      }
    }

  }
  public result getResult() {
    return result;
  }

  public Integer getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  public void setResult(TimelineEntry.result result) {
    this.result = result;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
