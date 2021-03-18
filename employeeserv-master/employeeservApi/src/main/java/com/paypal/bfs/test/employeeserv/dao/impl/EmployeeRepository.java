package com.paypal.bfs.test.employeeserv.dao.impl;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.dao.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

  @Query(nativeQuery = true,
      value = "SELECT count(*) FROM employee WHERE first_name = :first_name and last_name = :last_name and date_of_birth = :date_of_birth")
  public Integer getAddressByNameAndDOB(@Param("first_name") String firstName,
      @Param("last_name") String lastName, @Param("date_of_birth") String dateOfBirth);
}

