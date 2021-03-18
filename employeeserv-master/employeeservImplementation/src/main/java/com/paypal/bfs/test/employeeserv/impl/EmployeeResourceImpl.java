package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.IEmployeeManagerService;
import com.paypal.bfs.test.employeeserv.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeResponse;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

  @Autowired
  private IEmployeeManagerService empManagerService;

  @Override
  public ResponseEntity<Employee> employeeGetById(String id) {
    Employee emp = empManagerService.getEmployeeById(Integer.parseInt(id));
    if (emp.getId() != null) {
      return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    return new ResponseEntity<>(emp, HttpStatus.NOT_FOUND);
  }

  @Override
  public ResponseEntity<EmployeeResponse> saveEmployee(Employee employee) {
    EmployeeResponse response = inputValidation(employee);
    // validating input
    if (response.getResult()) {
      response = empManagerService.saveEmployee(employee);
      if (response.getResult()) {
        response.setMessage("Employee data saved successfully");
      }
    }
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  private EmployeeResponse inputValidation(Employee employee) {
    EmployeeResponse response = new EmployeeResponse();
    if (employee.getFirstName() == null || employee.getFirstName().trim().isEmpty()
        || !isProperName(employee.getFirstName())) {
      response.setCode("400");
      response.setMessage("Invalid first name");
      response.setResult(false);

      return response;
    }
    if (employee.getLastName() == null || employee.getLastName().trim().isEmpty()
        || !isProperName(employee.getLastName())) {
      response.setCode("400");
      response.setMessage("Invalid Last name");
      response.setResult(false);

      return response;
    }
    if (employee.getAddress().getCity() == null || employee.getAddress().getCity().trim().isEmpty()
        || !isProperName(employee.getAddress().getCity())) {
      response.setCode("400");
      response.setMessage("Invalid City name");
      response.setResult(false);

      return response;
    }
    if (employee.getAddress().getState() == null
        || employee.getAddress().getState().trim().isEmpty()
        || !isProperName(employee.getAddress().getState())) {
      response.setCode("400");
      response.setMessage("Invalid State name");
      response.setResult(false);

      return response;
    }
    if (employee.getAddress().getCountry() == null
        || employee.getAddress().getCountry().trim().isEmpty()
        || !isProperName(employee.getAddress().getCountry())) {
      response.setCode("400");
      response.setMessage("Invalid Country name");
      response.setResult(false);

      return response;
    }

    if (employee.getAddress().getLine1() == null
        || employee.getAddress().getLine1().trim().isEmpty()) {
      response.setCode("400");
      response.setMessage("Address Line 1 cannot be blank");
      response.setResult(false);

      return response;
    }

    if (employee.getAddress().getZipcode() == null
        || !isProperCode(employee.getAddress().getZipcode())) {
      response.setCode("400");
      response.setMessage("Invalid Zip code");
      response.setResult(false);

      return response;
    }
    response.setResult(true);
    response.setCode("200");
    response.setMessage("Validation successful");
    return response;
  }

  private Boolean isProperName(String str) {
    for (char ch : str.toCharArray()) {
      if (!Character.isLetter(ch) && ch != ' ') {
        return false;
      }
    }
    return true;
  }

  private Boolean isProperCode(String str) {
    return Pattern.matches("[0-9]{6}", str);
  }

}

