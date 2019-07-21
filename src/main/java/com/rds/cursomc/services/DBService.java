package com.rds.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rds.cursomc.domain.Address;
import com.rds.cursomc.domain.Brand;
import com.rds.cursomc.domain.Category;
import com.rds.cursomc.domain.City;
import com.rds.cursomc.domain.Client;
import com.rds.cursomc.domain.ItemPedido;
import com.rds.cursomc.domain.Payment;
import com.rds.cursomc.domain.PaymentCard;
import com.rds.cursomc.domain.PaymentCombotion;
import com.rds.cursomc.domain.Pedido;
import com.rds.cursomc.domain.Product;
import com.rds.cursomc.domain.State;
import com.rds.cursomc.domain.enums.Profile;
import com.rds.cursomc.domain.enums.StatePayment;
import com.rds.cursomc.domain.enums.TypeClient;
import com.rds.cursomc.repositories.AddressRepository;
import com.rds.cursomc.repositories.BrandRepository;
import com.rds.cursomc.repositories.CategoryRepository;
import com.rds.cursomc.repositories.CityRepository;
import com.rds.cursomc.repositories.ClientRepository;
import com.rds.cursomc.repositories.ItemPedidoRepository;
import com.rds.cursomc.repositories.PaymentRepository;
import com.rds.cursomc.repositories.PedidoRepository;
import com.rds.cursomc.repositories.ProductRepository;
import com.rds.cursomc.repositories.StateRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {
		
		Category cat1 = new Category(null, "Servir");
		Category cat2 = new Category(null, "Midro-ondas");
		Category cat3 = new Category(null, "Refregerador");
		Category cat4 = new Category(null, "Freezer");
		Category cat5 = new Category(null, "Infantil");
		Category cat6 = new Category(null, "Preparação");
		Category cat7 = new Category(null, "Armazenagem");
		Category cat8 = new Category(null, "PDA");
		
		Brand br1 = new Brand(null, "Tupperware", "A Tupperware oferece produtos de alta qualidade e tecnologia para toda família e também oportunidade de carreira e lucro como consultora Tupperware.");
		
		Product p1 = new Product(null, "Tupperware 1", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p2 = new Product(null, "Tupperware 2", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p3 = new Product(null, "Tupperware 3", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p4 = new Product(null, "Tupperware 4", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p5 = new Product(null, "Tupperware 5", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p6 = new Product(null, "Tupperware 6", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p7 = new Product(null, "Tupperware 7", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p8 = new Product(null, "Tupperware 8", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p9 = new Product(null, "Tupperware 9", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p10 = new Product(null, "Tupperware 10", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p11 = new Product(null, "Tupperware 11", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p12 = new Product(null, "Tupperware 12", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p13 = new Product(null, "Tupperware 13", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p14 = new Product(null, "Tupperware 14", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p15 = new Product(null, "Tupperware 15", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p16 = new Product(null, "Tupperware 16", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p17 = new Product(null, "Tupperware 17", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p18 = new Product(null, "Tupperware 18", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p19 = new Product(null, "Tupperware 19", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p20 = new Product(null, "Tupperware 20", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p21 = new Product(null, "Tupperware 21", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p22 = new Product(null, "Tupperware 22", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p23 = new Product(null, "Tupperware 23", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p24 = new Product(null, "Tupperware 24", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		Product p25 = new Product(null, "Tupperware 25", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p26 = new Product(null, "Tupperware 26", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p27 = new Product(null, "Tupperware 27", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p28 = new Product(null, "Tupperware 28", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p29 = new Product(null, "Tupperware 29", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p30 = new Product(null, "Tupperware 30", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p31 = new Product(null, "Tupperware 31", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p32 = new Product(null, "Tupperware 32", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p33 = new Product(null, "Tupperware 33", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p34 = new Product(null, "Tupperware 34", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p35 = new Product(null, "Tupperware 35", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p36 = new Product(null, "Tupperware 36", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p37 = new Product(null, "Tupperware 37", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p38 = new Product(null, "Tupperware 38", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p39 = new Product(null, "Tupperware 39", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p40 = new Product(null, "Tupperware 40", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p41 = new Product(null, "Tupperware 41", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p42 = new Product(null, "Tupperware 42", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p43 = new Product(null, "Tupperware 43", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p44 = new Product(null, "Tupperware 44", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p45 = new Product(null, "Tupperware 45", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p46 = new Product(null, "Tupperware 46", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p47 = new Product(null, "Tupperware 47", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p48 = new Product(null, "Tupperware 48", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p49 = new Product(null, "Tupperware 49", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p50 = new Product(null, "Tupperware 50", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p51 = new Product(null, "Tupperware 51", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p52 = new Product(null, "Tupperware 52", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p53 = new Product(null, "Tupperware 53", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p54 = new Product(null, "Tupperware 54", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p55 = new Product(null, "Tupperware 55", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		br1.getProducts().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17,
				p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39,
				p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50, p51, p52, p53, p54, p55));
		
		p1.getBrands().addAll(Arrays.asList(br1));
		p2.getBrands().addAll(Arrays.asList(br1));
		p3.getBrands().addAll(Arrays.asList(br1));
		p4.getBrands().addAll(Arrays.asList(br1));
		p5.getBrands().addAll(Arrays.asList(br1));
		p6.getBrands().addAll(Arrays.asList(br1));
		p7.getBrands().addAll(Arrays.asList(br1));
		p8.getBrands().addAll(Arrays.asList(br1));
		p9.getBrands().addAll(Arrays.asList(br1));
		p10.getBrands().addAll(Arrays.asList(br1));
		p11.getBrands().addAll(Arrays.asList(br1));		
		p12.getBrands().addAll(Arrays.asList(br1));
		p13.getBrands().addAll(Arrays.asList(br1));
		p14.getBrands().addAll(Arrays.asList(br1));
		p15.getBrands().addAll(Arrays.asList(br1));
		p16.getBrands().addAll(Arrays.asList(br1));
		p17.getBrands().addAll(Arrays.asList(br1));
		p18.getBrands().addAll(Arrays.asList(br1));
		p19.getBrands().addAll(Arrays.asList(br1));
		p20.getBrands().addAll(Arrays.asList(br1));
		p21.getBrands().addAll(Arrays.asList(br1));
		p22.getBrands().addAll(Arrays.asList(br1));
		p23.getBrands().addAll(Arrays.asList(br1));
		p24.getBrands().addAll(Arrays.asList(br1));
		p25.getBrands().addAll(Arrays.asList(br1));
		p26.getBrands().addAll(Arrays.asList(br1));
		p27.getBrands().addAll(Arrays.asList(br1));
		p28.getBrands().addAll(Arrays.asList(br1));
		p29.getBrands().addAll(Arrays.asList(br1));
		p30.getBrands().addAll(Arrays.asList(br1));
		p31.getBrands().addAll(Arrays.asList(br1));
		p32.getBrands().addAll(Arrays.asList(br1));
		p33.getBrands().addAll(Arrays.asList(br1));
		p34.getBrands().addAll(Arrays.asList(br1));
		p35.getBrands().addAll(Arrays.asList(br1));
		p36.getBrands().addAll(Arrays.asList(br1));
		p37.getBrands().addAll(Arrays.asList(br1));
		p38.getBrands().addAll(Arrays.asList(br1));
		p39.getBrands().addAll(Arrays.asList(br1));
		p40.getBrands().addAll(Arrays.asList(br1));
		p41.getBrands().addAll(Arrays.asList(br1));
		p42.getBrands().addAll(Arrays.asList(br1));
		p43.getBrands().addAll(Arrays.asList(br1));
		p44.getBrands().addAll(Arrays.asList(br1));
		p45.getBrands().addAll(Arrays.asList(br1));
		p46.getBrands().addAll(Arrays.asList(br1));
		p47.getBrands().addAll(Arrays.asList(br1));
		p48.getBrands().addAll(Arrays.asList(br1));
		p49.getBrands().addAll(Arrays.asList(br1));
		p50.getBrands().addAll(Arrays.asList(br1));
		p51.getBrands().addAll(Arrays.asList(br1));
		p52.getBrands().addAll(Arrays.asList(br1));
		p53.getBrands().addAll(Arrays.asList(br1));
		p54.getBrands().addAll(Arrays.asList(br1));
		p55.getBrands().addAll(Arrays.asList(br1));
		
		brandRepository.saveAll(Arrays.asList(br1));
		
		cat1.getProducts().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50, p51, p52, p53, p54, p55));
				
				p12.getCategories().add(cat1);
				p13.getCategories().add(cat1);
				p14.getCategories().add(cat1);
				p15.getCategories().add(cat1);
				p16.getCategories().add(cat1);
				p17.getCategories().add(cat1);
				p18.getCategories().add(cat1);
				p19.getCategories().add(cat1);
				p20.getCategories().add(cat1);
				p21.getCategories().add(cat1);
				p22.getCategories().add(cat1);
				p23.getCategories().add(cat1);
				p24.getCategories().add(cat1);
				p25.getCategories().add(cat1);
				p26.getCategories().add(cat1);
				p27.getCategories().add(cat1);
				p28.getCategories().add(cat1);
				p29.getCategories().add(cat1);
				p30.getCategories().add(cat1);
				p31.getCategories().add(cat1);
				p32.getCategories().add(cat1);
				p33.getCategories().add(cat1);
				p34.getCategories().add(cat1);
				p35.getCategories().add(cat1);
				p36.getCategories().add(cat1);
				p37.getCategories().add(cat1);
				p38.getCategories().add(cat1);
				p39.getCategories().add(cat1);
				p40.getCategories().add(cat1);
				p41.getCategories().add(cat1);
				p42.getCategories().add(cat1);
				p43.getCategories().add(cat1);
				p44.getCategories().add(cat1);
				p45.getCategories().add(cat1);
				p46.getCategories().add(cat1);
				p47.getCategories().add(cat1);
				p48.getCategories().add(cat1);
				p49.getCategories().add(cat1);
				p50.getCategories().add(cat1);	
				p51.getCategories().add(cat1);
				p52.getCategories().add(cat1);
				p53.getCategories().add(cat1);
				p54.getCategories().add(cat1);
				p55.getCategories().add(cat1);
				
				cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
				cat2.getProducts().addAll(Arrays.asList(p2, p4));
				cat3.getProducts().addAll(Arrays.asList(p5, p6));
				cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
				cat5.getProducts().addAll(Arrays.asList(p8));
				cat6.getProducts().addAll(Arrays.asList(p9, p10));
				cat7.getProducts().addAll(Arrays.asList(p11));
				
				p1.getCategories().addAll(Arrays.asList(cat1, cat4));
				p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
				p3.getCategories().addAll(Arrays.asList(cat1, cat4));
				p4.getCategories().addAll(Arrays.asList(cat2));
				p5.getCategories().addAll(Arrays.asList(cat3));
				p6.getCategories().addAll(Arrays.asList(cat3));
				p7.getCategories().addAll(Arrays.asList(cat4));
				p8.getCategories().addAll(Arrays.asList(cat5));
				p9.getCategories().addAll(Arrays.asList(cat6));
				p10.getCategories().addAll(Arrays.asList(cat6));
				p11.getCategories().addAll(Arrays.asList(cat7));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50, p51, p52, p53, p54, p55));
		
		
		State st1 = new State(null, "Goiás", "GO");
		State st2 = new State(null, "Mato Grosso", "MT");
		State st3 = new State(null, "Minas Gerais", "MG");
		State st4 = new State(null, "São Paulo", "SP");
		State st5 = new State(null, "Tocantins", "TO");
		State st6 = new State(null, "Distrito Federal", "DF");
		
		City c1 = new City(null, "Goiânia", st1);
		City c2 = new City(null, "Cuiabá", st2);
		City c3 = new City(null, "Uberlândia", st3);
		City c4 = new City(null, "Anápolis", st1);
		City c5 = new City(null, "Rondonópolis", st2);
		City c6 = new City(null, "Aparecida de Goiânia", st1);
		
		st1.getCities().addAll(Arrays.asList(c1, c4, c6));
		st2.getCities().addAll(Arrays.asList(c2, c5));
		st3.getCities().addAll(Arrays.asList(c3));
		
		stateRepository.saveAll(Arrays.asList(st1, st2, st3, st4, st5, st6));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
			
		Client cli1 = new Client(null, "Roberson Santos", "robersonupc@gmail.com", "31628382740", TypeClient.PESSOAFISICA, pe.encode("1234"));
		cli1.getTelephones().addAll(Arrays.asList("6293883321", "6234252625"));
		cli1.addPerfil(Profile.ADMIN);
		
		Client cli2 = new Client(null, "Rosangela Santos", "komtec.komatsu@gmail.com", "48843868179", TypeClient.PESSOAFISICA, pe.encode("123"));
		cli2.getTelephones().addAll(Arrays.asList("6235772346", "62993256370"));
		
		Address e1 = new Address(null, "Rua JC305", "7A", "Quadra 21 Condomínio Lotus - Interfone 71", "Jardim do Cerrado 7", "74491607", cli1, c1);
		Address e2 = new Address(null, "Av Anhaguera", "1804", "Edifícil Power center", "Centro", "74201982", cli1, c1);
		
		Address e3 = new Address(null, "Rua JC305", "12A", "Quadra 23 Condomínio Lilás", "Jardim do Cerrado 7", "74491607", cli2, c1);
		
		cli1.getAddresses().addAll(Arrays.asList(e1, e2));
		cli2.getAddresses().addAll(Arrays.asList(e3));
		
		clientRepository.saveAll(Arrays.asList(cli1, cli2));
		addressRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("24/06/2019 09:45"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("21/06/2019 14:45"), cli1, e2);
		
		Payment pgto1 = new PaymentCard(null, StatePayment.SETTLET, ped1, 6);
		ped1.setPayment(pgto1);
		
		Payment pgto2 = new PaymentCombotion(null, StatePayment.PENDING, ped2, sdf.parse("24/06/2019 00:00"), null);
		ped2.setPayment(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pgto1, pgto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p1, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p1, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p1.getItens().addAll(Arrays.asList(ip3));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}
}
