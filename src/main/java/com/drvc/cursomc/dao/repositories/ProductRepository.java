package com.drvc.cursomc.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drvc.cursomc.dao.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
