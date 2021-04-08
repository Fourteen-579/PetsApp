package com.fourteen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

  private String id;
  private String name;
  private int age;
  private String sex;
  private String imgUrl;
  private String location;

}
