package com.rds.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.cursomc.domain.Brand;
import com.rds.cursomc.repositories.BrandRepository;
import com.rds.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class BrandService {

	@Autowired
	private BrandRepository repo;

	public Brand find(Integer id) {
		Optional<Brand> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Brand.class.getName()));
	}
}