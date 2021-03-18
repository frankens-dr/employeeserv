package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.model.Employee;
import com.paypal.bfs.test.employeeserv.model.EmployeeResponse;

public interface IEmployeeManagerService {

  public Employee getEmployeeById(Integer employeeId);
  
  public EmployeeResponse saveEmployee(Employee employee);
  
}
