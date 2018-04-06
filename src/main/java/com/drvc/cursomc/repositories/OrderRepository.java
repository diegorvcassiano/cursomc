package com.drvc.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drvc.cursomc.domain.CustomerOrder;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Integer>{

}
