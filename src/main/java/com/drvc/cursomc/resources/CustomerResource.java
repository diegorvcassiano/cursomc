package com.drvc.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drvc.cursomc.domain.Customer;
import com.drvc.cursomc.services.CustomerService;

@RestController
@RequestMapping(value="/customers")
public class CustomerResource {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Customer> listCustomer( ) {
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findCustomerById(@PathVariable Integer id) {
		Customer obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);
	}
	
}