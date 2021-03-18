package com.paypal.bfs.test.employeeserv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.IEmployeeService;
import com.paypal.bfs.test.employeeserv.dao.impl.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.dao.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.mapper.Mapper;
import com.paypal.bfs.test.employeeserv.model.Employee;

@Service
public class EmployeeService implements IEmployeeService {

  @Autowired
  private EmployeeRepository empRepo;

  @Override
  public Employee getEmployeeById(Integer employeeId) throws NullPointerException {

    try {
      EmployeeEntity employeeEntity = empRepo.findById(employeeId).get();
      return Mapper.mapEmployeeEntityToEmployee(employeeEntity);
    } catch (Exception e) {
      throw new NullPointerException();
    }

  }

  @Override
  public Integer saveEmployee(Employee employee) {
    Integer employeealreadyPresent = empRepo.getAddressByNameAndDOB(employee.getFirstName(),
        employee.getLastName(), employee.getDateOfBirth());
    if (employeealreadyPresent > 0) {
      return -1;
    } else {
      try {
        EmployeeEntity entity = Mapper.mapEmployeeToEmployeeEntity(employee);
        return empRepo.save(entity).getId();
      } catch (Exception e) {
        return -1;
      }
    }
  }

}
