package com.paypal.bfs.test.employeeserv.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.IAddressService;
import com.paypal.bfs.test.employeeserv.api.IEmployeeManagerService;
import com.paypal.bfs.test.employeeserv.api.IEmployeeService;
import com.paypal.bfs.test.employeeserv.model.Address;
import com.paypal.bfs.test.employeeserv.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeResponse;

@Transactional
@Service
public class EmployeeManagerService implements IEmployeeManagerService {

  @Autowired
  private IEmployeeService empService;

  @Autowired
  private IAddressService addService;

  @Override
  public Employee getEmployeeById(Integer employeeId) {
    Employee employee = new Employee();
    try {
      employee = empService.getEmployeeById(employeeId);
      if (employee.getId() == null) {
        return employee;
      }
    } catch (Exception e) {
      return new Employee();
    }

    try {
      Address address = addService.getAddressByEmployeeId(employeeId);
      employee.setAddress(address);
    } catch (Exception e) {
      return new Employee();
    }
    return employee;
  }

  @Override
  public EmployeeResponse saveEmployee(Employee employee) {
    EmployeeResponse response = new EmployeeResponse();
    try {
      Integer empId = empService.saveEmployee(employee);
      if (empId == -1) {
        response.setCode("400");
        response.setMessage("Employee already exists");
        response.setResult(false);
        return response;
      }
      Address addr = employee.getAddress();
      if (addService.saveAddress(addr, empId)) {
        response.setCode("200");
        response.setMessage("Employee saved successfully");
        response.setResult(true);
        return response;
      }
      response.setCode("500");
      response.setMessage("Exception occured while saving employee data");
      response.setResult(false);
      return response;
    
    } catch (Exception e) {
      response.setCode("500");
      response.setMessage("Exception occured while saving employee data: " + e);
      response.setResult(false);
      return response;
    }

  }

}
