package com.rds.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rds.cursomc.domain.Client;
import com.rds.cursomc.repositories.ClientRepository;
import com.rds.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()));
	}
}