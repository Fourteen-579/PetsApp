package com.fourteen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RescueInfor {

  private String id;
  private String time;
  private String locale;
  private String state;
  private String label;
  private String describe;
  private String userId;


}
