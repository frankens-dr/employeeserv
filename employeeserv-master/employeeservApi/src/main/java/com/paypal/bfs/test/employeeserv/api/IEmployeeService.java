package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.model.Employee;

public interface IEmployeeService {

  public Employee getEmployeeById(Integer employeeId) throws NullPointerException;

  public Integer saveEmployee(Employee employee);
  
}
