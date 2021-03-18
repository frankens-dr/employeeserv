package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.dao.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.dao.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.model.Address;
import com.paypal.bfs.test.employeeserv.model.Employee;

public class Mapper {
  public static AddressEntity mapAddressToAddressEntity(Address address, Integer employeeId) {
    AddressEntity addr = new AddressEntity();
    addr.setCity(address.getCity());
    addr.setCountry(address.getCountry());
    addr.setEmployeeId(employeeId);
    addr.setLine1(address.getLine1());
    addr.setLine2(address.getLine2());
    addr.setState(address.getState());
    addr.setZipCode(address.getZipcode());
    return addr;
  }

  public static Address mapAddressEntityToAddress(AddressEntity address) {
    Address addr = new Address();
    addr.setCity(address.getCity());
    addr.setCountry(address.getCountry());
    addr.setLine1(address.getLine1());
    addr.setLine2(address.getLine2());
    addr.setState(address.getState());
    addr.setZipcode(address.getZipCode());
    return addr;
  }

  public static EmployeeEntity mapEmployeeToEmployeeEntity(Employee emp) {
    EmployeeEntity ee = new EmployeeEntity();
    ee.setDateOfBirth(emp.getDateOfBirth());
    ee.setFirstName(emp.getFirstName());
    ee.setLastName(emp.getLastName());
    ee.setId(emp.getId());
    return ee;
  }
  
  public static Employee mapEmployeeEntityToEmployee(EmployeeEntity emp) {
    Employee ee = new Employee();
    ee.setDateOfBirth(emp.getDateOfBirth());
    ee.setFirstName(emp.getFirstName());
    ee.setLastName(emp.getLastName());
    ee.setId(emp.getId());
    return ee;
  }
}
