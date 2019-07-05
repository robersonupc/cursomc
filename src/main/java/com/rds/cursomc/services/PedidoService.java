package com.rds.cursomc.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rds.cursomc.domain.Client;
import com.rds.cursomc.domain.ItemPedido;
import com.rds.cursomc.domain.PaymentCombotion;
import com.rds.cursomc.domain.Pedido;
import com.rds.cursomc.domain.enums.StatePayment;
import com.rds.cursomc.repositories.ItemPedidoRepository;
import com.rds.cursomc.repositories.PaymentRepository;
import com.rds.cursomc.repositories.PedidoRepository;
import com.rds.cursomc.security.UserSS;
import com.rds.cursomc.services.exceptions.AuthorizationException;
import com.rds.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private CombotionService combotionService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private EmailService emailService;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setClient(clientService.find(obj.getClient().getId()));
		obj.getPayment().setStatePayment(StatePayment.PENDING);
		obj.getPayment().setPedido(obj);
		if (obj.getPayment() instanceof PaymentCombotion) {
			PaymentCombotion pagto = (PaymentCombotion) obj.getPayment();
			combotionService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		
		paymentRepository.save(obj.getPayment());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduct(productService.find(ip.getProduct().getId()));
			ip.setPrice(ip.getProduct().getPrice());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}
	
	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Client client =  clientService.find(user.getId());
		return repo.findByClient(client, pageRequest);
	}
}