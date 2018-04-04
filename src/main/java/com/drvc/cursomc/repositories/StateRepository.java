package com.drvc.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drvc.cursomc.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
