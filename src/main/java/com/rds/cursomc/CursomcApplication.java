package com.rds.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rds.cursomc.domain.Address;
import com.rds.cursomc.domain.Category;
import com.rds.cursomc.domain.City;
import com.rds.cursomc.domain.Client;
import com.rds.cursomc.domain.Product;
import com.rds.cursomc.domain.State;
import com.rds.cursomc.domain.enums.TypeClient;
import com.rds.cursomc.repositories.AddressRepository;
import com.rds.cursomc.repositories.BrandRepository;
import com.rds.cursomc.repositories.CategoryRepository;
import com.rds.cursomc.repositories.CityRepository;
import com.rds.cursomc.repositories.ClientRepository;
import com.rds.cursomc.repositories.ProductRepository;
import com.rds.cursomc.repositories.StateRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
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
				"A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas, podendo sempre variar o sabor.",
				"colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", null,	null, null);

		
		cat1.getProducts().addAll(Arrays.asList(p1));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		productRepository.saveAll(Arrays.asList(p1));
		
		State st1 = new State(null, "Goiás", "GO");
		State st2 = new State(null, "Mato Grosso", "MT");
		State st3 = new State(null, "Minas Gerais", "MG");
		State st4 = new State(null, "São Paulo", "SP");
		State st5 = new State(null, "Tocantins", "TO");
		State st6 = new State(null, "Distrito Federal", "DF");
		
		City c1 = new City(null, "Goiânia", st1);
		City c2 = new City(null, "Cuiabá", st2);
		City c3 = new City(null, "Uberlândia", st3);
		
		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2));
		st3.getCities().addAll(Arrays.asList(c3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2, st3, st4, st5, st6));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Client cli1 = new Client(null, "Roberson Santo", "robersonupc@gmailcom", "48843868179", TypeClient.PESSOAFISICA);
		cli1.getTelephones().addAll(Arrays.asList("6235772346", "62993256370"));
		
		Address e1 = new Address(null, "Rua JC305", "7A", "Quadra 21 Condomínio Lotus - Interfone 71", "Jardim do Cerrado 7", "74491607", cli1, c1);
		Address e2 = new Address(null, "Av Anhaguera", "1804", "Edifícil Power center", "Centro", "74201982", cli1, c1);
		
		cli1.getAddresses().addAll(Arrays.asList(e1, e2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(e1, e2));
		
		
		
	}
	
	

}
