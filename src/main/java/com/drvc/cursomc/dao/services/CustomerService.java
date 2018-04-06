package com.drvc.cursomc.dao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drvc.cursomc.dao.domain.Customer;
import com.drvc.cursomc.dao.repositories.CustomerRepository;
import com.drvc.cursomc.dao.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public Customer findById(Integer id) {
		Optional<Customer> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Customer.class.getName()));
	}
}
