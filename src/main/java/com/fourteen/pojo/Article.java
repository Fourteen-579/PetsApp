package com.fourteen.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

  private String id;
  private String title;
  private String imgUrl;
  private String content;
  private String userId;
  private String time;

}
