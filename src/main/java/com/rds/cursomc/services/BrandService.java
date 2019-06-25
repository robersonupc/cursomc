package com.rds.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rds.cursomc.domain.Brand;
import com.rds.cursomc.dto.BrandDTO;
import com.rds.cursomc.repositories.BrandRepository;
import com.rds.cursomc.services.exceptions.DataIntegratyException;
import com.rds.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class BrandService {

	@Autowired
	private BrandRepository repo;

	public Brand find(Integer id) {
		Optional<Brand> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Brand.class.getName());
		}
		return null;
		
	}
	
	public Brand insert(Brand obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Brand update(Brand obj) {
		
		find(obj.getId());
		
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegratyException("Não é possível excluir o fabricante que possui produtos!");
		}
	}
	
	public List<Brand> findAll(){
		return repo.findAll();
	}
	
	public Page<Brand> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Brand fromDTO(BrandDTO objDto) {
		
		return new Brand(objDto.getId(), objDto.getName(), objDto.getDescription());
	}
}