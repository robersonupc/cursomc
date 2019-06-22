package com.rds.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rds.cursomc.domain.Category;
import com.rds.cursomc.repositories.CategoryRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Servir");
		Category cat2 = new Category(null, "Midro-ondas");
		Category cat3 = new Category(null, "Refregerador");
		Category cat4 = new Category(null, "Freezer");
		
		repo.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
	}
	
	

}
