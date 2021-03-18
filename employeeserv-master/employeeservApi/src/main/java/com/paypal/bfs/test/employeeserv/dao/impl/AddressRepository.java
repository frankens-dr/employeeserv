package com.paypal.bfs.test.employeeserv.dao.impl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.dao.model.AddressEntity;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {

  @Query(nativeQuery = true,
      value = "SELECT * FROM address WHERE employee_id = :employee_id")
  public AddressEntity getAddressByEmployeeId(@Param("employee_id") Integer employeeId);
}
