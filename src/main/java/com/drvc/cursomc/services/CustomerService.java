package com.drvc.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drvc.cursomc.domain.Customer;
import com.drvc.cursomc.repositories.CustomerRepository;
import com.drvc.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public Customer findById(Integer id) {
		Optional<Customer> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Customer.class.getName()));
	}
}
