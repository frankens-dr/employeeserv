package com.paypal.bfs.test.employeeserv.model;

public class EmployeeResponse {

  private Boolean result;
  private String code;
  private String message;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Boolean getResult() {
    return result;
  }

  public void setResult(Boolean result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "EmployeeResponse [result=" + result + ", code=" + code + ", message=" + message + "]";
  }

}

