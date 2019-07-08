package com.rds.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.cursomc.domain.State;
import com.rds.cursomc.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repo;
	
	public List<State> findAll() {
		return repo.findAllByOrderByName();
	}

}
