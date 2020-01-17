package com.ahmad.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.ahmad.dtos.CustomerDto;
import com.ahmad.entities.CustomerEntity;
import com.ahmad.repository.customerRepository;

@Service
public class CustomerService {

	private customerRepository customerRepository;
	
	public void createCustomer(CustomerDto dto) {
		CustomerEntity entity=null;
		if (dto != null) {
			entity=new CustomerEntity();
			entity.setFirstName(dto.getFirstName());
			entity.setLastName(dto.getLastName());
			entity.setEmail(dto.getEmail());
			entity.setPhone(dto.getPhone());
			
			Random random = new Random();
			entity.setUid(random.toString());
			
			customerRepository.save(entity);
		}
	}
}
