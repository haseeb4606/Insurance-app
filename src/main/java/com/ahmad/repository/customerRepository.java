package com.ahmad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmad.entities.CustomerEntity;

@Repository
public interface customerRepository extends CrudRepository<CustomerEntity, Long>{

}
