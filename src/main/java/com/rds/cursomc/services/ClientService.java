package com.rds.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rds.cursomc.domain.Address;
import com.rds.cursomc.domain.City;
import com.rds.cursomc.domain.Client;
import com.rds.cursomc.domain.enums.TypeClient;
import com.rds.cursomc.dto.ClientDTO;
import com.rds.cursomc.dto.ClientNewDTO;
import com.rds.cursomc.repositories.AddressRepository;
import com.rds.cursomc.repositories.ClientRepository;
import com.rds.cursomc.services.exceptions.DataIntegratyException;
import com.rds.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private ClientRepository repo;
	
	@Autowired
	private AddressRepository addressRepository;

	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
	}
	
	public Client insert(Client obj) {
		obj.setId(null);
		obj = repo.save(obj);
		addressRepository.saveAll(obj.getAddresses());
		return obj;
	}

	public Client update(Client obj) {
		Client newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegratyException("Não é possível excluir um cliente que possui vendas cadastrada!");
		}
	}

	public List<Client> findAll() {
		return repo.findAll();
	}

	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Client fromDTO(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null, null);
	}
	
	public Client fromDTO(ClientNewDTO objDto) {
		Client cli = new Client(null, objDto.getName(), objDto.getEmail(), objDto.getCpfCnpj(), TypeClient.toEnum(objDto.getType()), pe.encode(objDto.getPassword()));
		City cid = new City(objDto.getCityId(), null, null);
		Address end = new Address(null, objDto.getLogradouro(), objDto.getNumber(), objDto.getComplement(), objDto.getNeighborhood(), objDto.getZipCode(), cli, cid);
		cli.getAddresses().add(end);
		cli.getTelephones().add(objDto.getTelephone1());
		if(objDto.getTelephone2()!=null) {
			cli.getTelephones().add(objDto.getTelephone2());
		}
		if(objDto.getTelephone3()!=null) {
			cli.getTelephones().add(objDto.getTelephone3());
		}
		return cli;
	}
	
	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
}