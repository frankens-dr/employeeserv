package com.paypal.bfs.test.employeeserv.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "line1", "line2", "city", "state", "country", "zip_code" })
public class Address {

  @NotNull
  private String line1;
  private String line2;
  @NotNull
  private String city;
  @NotNull
  private String state;
  @NotNull
  private String country;
  @NotNull
  private String zipcode;

  @JsonProperty("line1")
  @JsonPropertyDescription("address line 1")
  public String getLine1() {
    return line1;
  }

  @JsonProperty("line1")
  @JsonPropertyDescription("address line 1")
  public void setLine1(String line1) {
    this.line1 = line1;
  }

  @JsonProperty("line2")
  @JsonPropertyDescription("address line 2")
  public String getLine2() {
    return line2;
  }

  @JsonProperty("line2")
  @JsonPropertyDescription("address line 2")
  public void setLine2(String line2) {
    this.line2 = line2;
  }

  @JsonProperty("city")
  @JsonPropertyDescription("city")
  public String getCity() {
    return city;
  }

  @JsonProperty("city")
  @JsonPropertyDescription("city")
  public void setCity(String city) {
    this.city = city;
  }

  @JsonProperty("state")
  @JsonPropertyDescription("state")
  public String getState() {
    return state;
  }

  @JsonProperty("state")
  @JsonPropertyDescription("state")
  public void setState(String state) {
    this.state = state;
  }

  @JsonProperty("country")
  @JsonPropertyDescription("country")
  public String getCountry() {
    return country;
  }

  @JsonProperty("country")
  @JsonPropertyDescription("country")
  public void setCountry(String country) {
    this.country = country;
  }

  @JsonProperty("zip_code")
  @JsonPropertyDescription("zip code")
  public String getZipcode() {
    return zipcode;
  }

  @JsonProperty("zip_code")
  @JsonPropertyDescription("zip code")
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  @Override
  public String toString() {
    return "Address [line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state
        + ", country=" + country + ", zipcode=" + zipcode + "]";
  }

}
