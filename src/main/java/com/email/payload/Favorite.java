package com.email.payload;


import lombok.Data;

@Data
public class Favorite {
  private String name;
  private String image;
  private String type;
  private String summary;
  private String country;
  private String destinationCode;
  private String url;

}