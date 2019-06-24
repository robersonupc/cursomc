package com.rds.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.cursomc.domain.Brand;
import com.rds.cursomc.services.BrandService;

@RestController
@RequestMapping(value = "/brands")
public class BrandResource {
	
	@Autowired
	private BrandService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {	
		
		Brand obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
