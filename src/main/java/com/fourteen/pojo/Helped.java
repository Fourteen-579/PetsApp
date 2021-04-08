package com.fourteen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Helped {

  private String id;
  private Date time;
  private String preImgUrl;
  private String aftImgUrl;
  private String helpId;
  private String experience;
  private String publisherId;
  private int age;
  private String type;
  private String state;
  private String name;
  private String location;




}
