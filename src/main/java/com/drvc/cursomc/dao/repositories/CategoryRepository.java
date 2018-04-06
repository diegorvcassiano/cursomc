package com.drvc.cursomc.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drvc.cursomc.dao.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
