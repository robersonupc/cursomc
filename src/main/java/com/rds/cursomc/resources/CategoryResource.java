package com.rds.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rds.cursomc.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> listar() {
		
		Category cat1 = new Category(1, "Servir");
		Category cat2 = new Category(2, "Freezer");
		Category cat3 = new Category(3, "Refrigerador");
		Category cat4 = new Category(4, "Micro-ondas");
		
		List<Category> lista = new ArrayList<Category>();
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
		
		return lista;
	}

}
