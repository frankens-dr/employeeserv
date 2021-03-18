
package com.paypal.bfs.test.employeeserv.model;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Employee resource
 * <p>
 * Employee resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "first_name", "last_name", "date_of_birth", "address" })
public class Employee {

  /**
   * employee id
   * 
   */
  @JsonProperty("id")
  @JsonPropertyDescription("employee id")
  @NotNull
  private Integer id;
  /**
   * first name (Required)
   * 
   */
  @JsonProperty("first_name")
  @JsonPropertyDescription("first name")
  @NotNull
  private String firstName;
  /**
   * last name (Required)
   * 
   */
  @JsonProperty("last_name")
  @JsonPropertyDescription("last name")
  @NotNull
  private String lastName;
  
  @JsonProperty("date_of_birth")
  @JsonPropertyDescription("date of birth")
  @NotNull
  private String dateOfBirth;
  
  @JsonProperty("address")
  @JsonPropertyDescription("address")
  @NotNull
  private Address address;
  
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   * employee id
   * 
   */
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  /**
   * employee id
   * 
   */
  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * first name (Required)
   * 
   */
  @JsonProperty("first_name")
  public String getFirstName() {
    return firstName;
  }

  /**
   * first name (Required)
   * 
   */
  @JsonProperty("first_name")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * last name (Required)
   * 
   */
  @JsonProperty("last_name")
  public String getLastName() {
    return lastName;
  }

  /**
   * last name (Required)
   * 
   */
  @JsonProperty("last_name")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @JsonProperty("date_of_birth")
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  @JsonProperty("date_of_birth")
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @JsonProperty("address")
  public Address getAddress() {
    return address;
  }

  @JsonProperty("address")
  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
        + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", additionalProperties="
        + additionalProperties + "]";
  }

}
