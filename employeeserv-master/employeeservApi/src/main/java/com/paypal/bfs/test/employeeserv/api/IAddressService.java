package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.model.Address;

public interface IAddressService {

  public Address getAddressByEmployeeId(Integer employeeId) throws NullPointerException;
  
  public Boolean saveAddress(Address address, Integer employeeId);
  
}
