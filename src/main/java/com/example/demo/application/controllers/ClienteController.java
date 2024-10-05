package com.example.demo.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.models.dtos.ClienteRequestDto;
import com.example.demo.domain.models.entities.Cliente;
import com.example.demo.domain.services.impl.ClienteRepositoryImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@PostMapping
	public String post(@RequestBody @Valid ClienteRequestDto dto) {

		var cliente = new Cliente();

		cliente.setId(UUID.randomUUID());
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefone(dto.getTelefone());

		var clienteRepository = new ClienteRepositoryImpl();
		clienteRepository.insert(cliente);

		return "Cliente cadastrado com sucesso!";
	}

	@PutMapping("{id}")
	public String put(@PathVariable UUID id, @RequestBody @Valid ClienteRequestDto dto) {

		var clienteRepository = new ClienteRepositoryImpl();

		var cliente = clienteRepository.findById(id);

		if (cliente == null) {
			return "ID inválido. Verifique o ID informado.";
		}

		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefone(dto.getTelefone());

		clienteRepository.update(id, cliente);

		return "Cliente atualizado com sucesso!";
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) {

		var clienteRepository = new ClienteRepositoryImpl();

		var cliente = clienteRepository.findById(id);

		if (cliente == null) {
			return "ID inválido. Verifique o ID informado.";
		}

		clienteRepository.delete(id);

		return "Cliente excluído com sucesso!";

	}

	@GetMapping("{id}")
	public Cliente getById(UUID id) {

		var clienteRepository = new ClienteRepositoryImpl();

		return clienteRepository.findById(id);
	}

	@GetMapping
	public List<Cliente> getAll() {

		var clienteRepository = new ClienteRepositoryImpl();

		return clienteRepository.findAll();
	}

}
