package com.ahmad.repository;

import org.springframework.data.repository.CrudRepository;

import com.ahmad.entities.CustomerEntity;

public interface customerRepository extends CrudRepository<CustomerEntity, Long>{

}
