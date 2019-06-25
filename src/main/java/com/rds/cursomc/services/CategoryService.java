package com.rds.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rds.cursomc.domain.Category;
import com.rds.cursomc.repositories.CategoryRepository;
import com.rds.cursomc.services.exceptions.DataIntegratyException;
import com.rds.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Category.class.getName());
		}
		return null;
		
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Category update(Category obj) {
		
		find(obj.getId());
		
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegratyException("Não é possível excluir uma categoria que possui produtos!");
		}
	}
	
}

