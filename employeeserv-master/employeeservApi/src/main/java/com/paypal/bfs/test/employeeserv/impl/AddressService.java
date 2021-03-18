package com.paypal.bfs.test.employeeserv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.IAddressService;
import com.paypal.bfs.test.employeeserv.dao.impl.AddressRepository;
import com.paypal.bfs.test.employeeserv.dao.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.mapper.Mapper;
import com.paypal.bfs.test.employeeserv.model.Address;

@Service
public class AddressService implements IAddressService {

  @Autowired
  private AddressRepository addrRepo;

  @Override
  public Address getAddressByEmployeeId(Integer employeeId) throws NullPointerException {
    try {
      AddressEntity entity = addrRepo.getAddressByEmployeeId(employeeId);
      System.out.println(entity);
      return Mapper.mapAddressEntityToAddress(entity);
    } catch (Exception e) {
      throw new NullPointerException();
    }

  }

  @Override
  public Boolean saveAddress(Address address, Integer employeeId) {
    System.out.println("Saving address");
    try {
      AddressEntity entity = Mapper.mapAddressToAddressEntity(address, employeeId);
      addrRepo.save(entity);
      System.out.println("address saved");
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
