package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.entities.Cliente;

public interface ClienteRepository {

	void insert(Cliente cliente);
	
	void update(UUID id, Cliente cliente);
	
	void delete(UUID id);
	
	List<Cliente> findAll();
	
	Cliente findById(UUID id);
}
