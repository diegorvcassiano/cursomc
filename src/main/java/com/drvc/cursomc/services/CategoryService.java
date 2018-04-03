package com.drvc.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drvc.cursomc.domain.Category;
import com.drvc.cursomc.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category findById(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
