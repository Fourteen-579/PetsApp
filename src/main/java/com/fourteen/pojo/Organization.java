package com.fourteen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

  private String id;
  private String name;
  private String location;
  private int members;
  private String imgUrl;
  private String describe;
  private String pwd;



}
