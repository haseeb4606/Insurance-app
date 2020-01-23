package com.ahmad.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ahmad.dtos.CustomerDto;
import com.ahmad.entities.CustomerEntity;
import com.ahmad.repository.CustomerMongoRepository;
import com.ahmad.repository.customerRepository;
import com.ahmad.util.EmailService;

@Service
public class CustomerService {

	@Autowired
	private customerRepository customerRepository;
	@Autowired
	private CustomerMongoRepository repository;
	@Autowired
	private EmailService emailService;

	public CustomerDto createCustomer(CustomerDto dto) {
		CustomerEntity entity = null;
		if (dto != null) {
		entity = new CustomerEntity();
//			entity.setFirstName(dto.getFirstName());
//			entity.setLastName(dto.getLastName());
//			entity.setEmail(dto.getEmail());
//			entity.setPhone(dto.getPhone());
            BeanUtils.copyProperties(dto, entity);
			entity.setUid(UUID.randomUUID().toString());

			customerRepository.save(entity);
			repository.save(entity);
			emailService.welcomeEmail(dto.getEmail());
		}
         CustomerDto dto1 = new CustomerDto();
		BeanUtils.copyProperties(entity, dto1);
		System.out.println(dto1.toString());
		return dto1;
	}
}
