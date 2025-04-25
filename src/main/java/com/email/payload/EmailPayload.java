package com.email.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Data;


@Data
public class EmailPayload {

  @JsonProperty("Favorites")
  private List<Favorite> favorites;

  @JsonProperty("Planner-Events")
  private List<PlannerEvent> plannerEvents;

  @JsonProperty("First-Name")
  private String firstName;

  @JsonProperty("Last-Name")
  private String lastName;

  @JsonProperty("Email")
  private String email;

  @JsonProperty("Address")
  private String address;

  @JsonProperty("City")
  private String city;

  @JsonProperty("ZIP-Code")
  private String zipCode;

  @JsonProperty("Country")
  private String country;

  @JsonProperty("Message")
  private String message;

  @JsonProperty("Subscribe-to-newsletter")
  private String subscribeToNewsletter;

}
