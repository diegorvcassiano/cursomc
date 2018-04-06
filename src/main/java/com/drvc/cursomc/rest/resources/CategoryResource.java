package com.drvc.cursomc.rest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drvc.cursomc.dao.domain.Category;
import com.drvc.cursomc.dao.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> listCategory( ) {
		return null;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findCategoryById(@PathVariable Integer id) {
		Category obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);
	}
	
}
