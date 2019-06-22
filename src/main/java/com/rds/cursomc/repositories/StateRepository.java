package com.rds.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rds.cursomc.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
