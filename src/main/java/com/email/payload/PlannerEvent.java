package com.email.payload;

import lombok.Data;

@Data
public class PlannerEvent {
  private String id;
  private String title;
  private String type;
  private String country;
  private String link;
  private String start;
  private String end;
  private boolean allDay;
  private String image;
  private String color;
}
