package com.rds.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
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

	public void instaciateTestDatabase() throws ParseException {
		
		Brand br1 = new Brand(null, "Caterpillar", null);
		Brand br2 = new Brand(null, "Komatsu", null);
		Brand br3 = new Brand(null, "Tupperware", null);
		
		brandRepository.saveAll(Arrays.asList(br1, br2, br3));
		
		Category cat1 = new Category(null, "Servir");
		Category cat2 = new Category(null, "Midro-ondas");
		Category cat3 = new Category(null, "Refregerador");
		Category cat4 = new Category(null, "Freezer");
		Category cat5 = new Category(null, "Infantil");
		Category cat6 = new Category(null, "Preparação");
		Category cat7 = new Category(null, "Armazenagem");
		Category cat8 = new Category(null, "PDA");
		Category cat9 = new Category(null, "Freezer2");
		Category cat10 = new Category(null, "Freezer3");
		Category cat11 = new Category(null, "Freezer4");
		
		Product p1 = new Product(null, "Tupperware A Jarra Colors Vinho 2 Litros", "Deixe tudo mais organizado Tupperware CJarra Colors 2 Litros é na CerradoTupperware", 
				104.90, "A Jarra Colors com capacidade para 2 Litros, vem com um infusor que se encaixa na tampa e permite que você faça sua própria bebida aromatizada, como águas e chás com suas frutas preferidas.",
		"Colors", "Jarra", "Vermelha", "2 litros", "21,4 cm (comp.) x 14 cm (larg.) x 23 cm (alt.)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p2 = new Product(null, "Tupperware Eco Tupper Plus Chery 1 Litro", "Deixe tudo mais organizado Eco Tupper Garrafa é na CerradoTupperware", 
				69.90, "A Eco Tupper Garrafa é o produto ideal para você transportar líquidos com você para todos os lugares! tem tamanho ideal para ser levada em bolsas e mochilas!",
		"Eco Tupper", "Garrafa / Squeeze", "Cherry", "1 litro", "7,4 cm. de diâmetro x 21 cm. altura", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno.- Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo.",
		" Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4- Atenderemos enquanto durar o estoque.- Se a tampa estiver muito apertada.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p3 = new Product(null, "Tupperware Turbo Chef Vermelho", "Deixe tudo mais organizado, Turbo Chef Vermelho é na CerradoTupperware", 
				204.90, "O Turbo Chef é um produto único, que vem com uma nova tecnologia de corte através de uma alavanca acionada quando a corda do produto é puxada.",
		"Turbo Chef", "Turbo Chef", "Vermelho", "300ml", "10,8 cm de diâmetro x 8 cm de altura", "Base, lâmina e tampa", 
		"Não levar no freezer/congelador ou forno. -Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo!",
		"Não contém Bisfenol A - Bisfenol Free  - Plásticos Usado na Tupperware: PP5 e LDPE4 -Atenderemos enquanto durar o estoque. -Se a tampa estiver muito apertada.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p4 = new Product(null, "Tupperware Tupper Caixa Amendoim 1,1 Litro Bistrô", "Deixe tudo mais organizado Tupperware Caixa Amendoim Bistrô é na CerradoTupperware", 
				36.90, "A linha de Tupper Caixas Bistrô traz um conceito para estimular sua criatividade, em tons pastéis sutis, design retrô, estílo rústico, acochego, modernidade... Tudo ao mesmo tempo!",
		"Bistrô - Chalkboard", "-", "Preto e Vermelho", "1,1 litros", "16,3 comp. x 15 larg. x 10,7 alt. (cm)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo!",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p5 = new Product(null, "Tupperware Caixa Café Bistrô 700g", "Deixe tudo mais organizado Tupperware Caixa Café é na CerradoTupperware", 
				59.90, "A linha de Tupper Caixas Café Bistrô traz um conceito para estimular sua criatividade, em tons pastéis sutis, design retrô, estílo rústico, acochego, modernidade... Tudo ao mesmo tempo!",
		"Bistrô - Chalkboard", "-", "Preto com Azul", "	700g", "18,2 comprimento x 16,7 largura x 12,3 altura (cm)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo!",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p6 = new Product(null, "Tupperware Faca Utilitária Média", "Deixe tudo mais organizado Tupperware Utilitária Média  é na CerradoTupperware", 
				89.90, "Uma coleção completa e de alta performance, com design único e elegante. A Faca Utilitária é ideal para cortar frutas em pedaços ou em rodelas.",
		"Universal Series", "Faca", "Azul", "-", "24,1cm de comprimento", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p7 = new Product(null, "Tupperware Jeitosinho Cheiro Verde 400 ml", "Deixe tudo mais organizado, Jeitosinho 400ml é na CerradoTupperware", 
				29.90, "A Linha Jeitosos foi desenvolvida com material flexível especial para baixas temperaturas, permitindo que o produto não rache com a expansão natural dos alimentos que ocorre quando os mesmos são congelados.",
		"Jeitosos", "-", "Verde", "	400ml", "12,8 comprimento x 11,2 largura x 5,6 altura (cm)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		" Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
				
		Product p8 = new Product(null, "Tupperware Faca do Chefe", "Deixe tudo mais organizado Tupperware Faca do Chefe é na CerradoTupperware", 
				154.90, "Uma coleção completa e de alta performance, com design único e elegante. A Faca Utilitária é ideal para cortar frutas em pedaços ou em rodelas.",
		"Universal Series", "Faca", "Verde", "-", "33,6cm de comprimento", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p9 = new Product(null, "Tupperware Speedy Chef", "Deixe tudo mais organizado Tupperware Speedy Chef é na CerradoTupperware", 
				179.90, "O Speedy Chef é um produto revolucionário, desenvolvido para facilitar a tarefa de bater cremes, claras em neve e massas leves. Além de não utilizar energia elétrica.",
		"Chef", "Multiuso", "Roxo", "1,2 Litros", "14,4cm de diâm x 26,2cm de alt", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		Product p10 = new Product(null, "Tupperware Basic Line 500 ml", "Deixe tudo mais organizado Tupperware Basic é na CerradoTupperware", 
				31.90, "O Basic Line é ideal para conservar muito bem organizados seus ingredientes dentro do seu refrigerador.",
		"Basic Line", "-", "Marsala", "500ml", "13 comprimento x 13 largura x 7 altura (cm)", "1 peça (Base e tampa)", 
		"Não levar no freezer/congelador, micro-ondas ou forno. - Não lavar com o lado verde(áspero) da esponja, usar o lado macio para manter a beleza do seu produto por muito tempo! - Não use produtos químicos e abrasivos.",
		"Não contém Bisfenol A - Bisfenol Free - Plásticos Usado na Tupperware: PP5 e LDPE4 - Atenderemos enquanto durar o estoque. - Se a tampa estiver muito apertada, deixe a tampa de molho em água morna durante 5 minutos.", 
		"Para calcular o prazo de entrega é necessário somar o prazo do correio e o prazo do site. Prezamos pela satisfação de nossos clientes");
		
		cat1.getProducts().addAll(Arrays.asList(p1));
		cat3.getProducts().addAll(Arrays.asList(p2, p10));
		cat6.getProducts().addAll(Arrays.asList(p3, p8, p9, p6));
		cat7.getProducts().addAll(Arrays.asList(p4, p5));
		cat4.getProducts().addAll(Arrays.asList(p7));
		
		br3.getProducts().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat3));
		p3.getCategories().addAll(Arrays.asList(cat6));
		p4.getCategories().addAll(Arrays.asList(cat7));
		//p5.getCategories().addAll(Arrays.asList(cat7));
		//p6.getCategories().addAll(Arrays.asList(cat6));
		p7.getCategories().addAll(Arrays.asList(cat4));
		//p8.getCategories().addAll(Arrays.asList(cat6));
		//p9.getCategories().addAll(Arrays.asList(cat6));
		//p10.getCategories().addAll(Arrays.asList(cat3));
		
		p1.getBrands().addAll(Arrays.asList(br3));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11));
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
		
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
