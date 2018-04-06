package com.drvc.cursomc.rest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drvc.cursomc.dao.domain.CustomerOrder;
import com.drvc.cursomc.dao.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CustomerOrder> listOrder( ) {
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findOrderById(@PathVariable Integer id) {
		CustomerOrder obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);
	}
	
}
