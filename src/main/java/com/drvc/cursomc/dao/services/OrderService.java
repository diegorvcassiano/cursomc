package com.drvc.cursomc.dao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drvc.cursomc.dao.domain.CustomerOrder;
import com.drvc.cursomc.dao.repositories.OrderRepository;
import com.drvc.cursomc.dao.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	public CustomerOrder findById(Integer id) {
		Optional<CustomerOrder> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + CustomerOrder.class.getName()));
	}
}
