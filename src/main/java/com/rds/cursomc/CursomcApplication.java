package com.rds.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rds.cursomc.domain.Category;
import com.rds.cursomc.domain.Product;
import com.rds.cursomc.repositories.CategoryRepository;
import com.rds.cursomc.repositories.ProductRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Servir");
		Category cat2 = new Category(null, "Midro-ondas");
		Category cat3 = new Category(null, "Refregerador");
		Category cat4 = new Category(null, "Freezer");
		
		Product p1 = new Product(null, "Tupperware A Jarra Colors Vinho 2 Litros", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na Rosa Tupperware", 104.90,
				"A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas, podendo sempre variar o sabor.");
		Product p2 = new Product(null, "Tupperware Quick Shake II 500ml Lilás", "Deixe tudo mais organizado Tupperware Tupperware Quick Shake II 500 ml é na Rosa Tupperware",
					49.90, "O Quick Shake é um produto simples, mas muito prático. Extremamente útil no dia a dia de qualquer casa, prepara massas finas, molhos, cremes e coquetéis!");
		Product p3 = new Product(null, "Tupperware Eco Tupper Plus Rosa Neon Paradise 500 ml",
				"Matar a sede é fácil com a Tupperware Eco Tupper Garrafa Plus é na Rosa Tupperware", 45.00,				
				"A Eco Tupper Garrafa é o produto ideal para você transportar líquidoscom você para todos os lugares!");
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
	}
	
	

}
