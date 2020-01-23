package com.ahmad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ahmad.entities.CustomerEntity;

@Repository
public interface CustomerMongoRepository extends MongoRepository<CustomerEntity, String>{

}
