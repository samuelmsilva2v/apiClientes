package com.example.demo.domain.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.entities.Cliente;
import com.example.demo.domain.services.interfaces.ClienteRepository;
import com.example.demo.insfrastructure.factories.ConnectionFactory;

public class ClienteRepositoryImpl implements ClienteRepository {

	@Override
	public void insert(Cliente cliente) {
		
		try {
			
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("INSERT INTO cliente(id, nome, email, telefone) VALUES(?, ?, ?, ?)");
			statement.setString(1, cliente.getId().toString());
			statement.setString(2, cliente.getNome());
			statement.setString(3, cliente.getEmail());
			statement.setString(4, cliente.getTelefone());
			statement.execute();
			
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(UUID id, Cliente cliente) {
		try {
			
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("UPDATE cliente SET nome=?, email=?, telefone=? WHERE id=?");
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getEmail());
			statement.setString(3, cliente.getTelefone());
			statement.setString(4, id.toString());
			statement.execute();
			
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(UUID id) {
		
		try {
			
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("DELETE FROM cliente WHERE id=?");
			statement.setString(1, id.toString());
			statement.execute();
			
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Cliente> findAll() {
		
		try {
			
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("SELECT * FROM cliente");
			var resultSet = statement.executeQuery();
			
			var clientes = new ArrayList<Cliente>();
			
			while(resultSet.next()) {
				
				var cliente = new Cliente();
				
				cliente.setId(UUID.fromString(resultSet.getString("id")));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setDataCadastro(new Date(resultSet.getTimestamp("datacadastro").getTime()));
				
				clientes.add(cliente);
			}
			
			connection.close();
			
			return clientes;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Cliente findById(UUID id) {
		try {
			
			var connectionFactory = new ConnectionFactory();
			var connection = connectionFactory.getConnection();
			
			var statement = connection.prepareStatement("SELECT * FROM cliente WHERE id=?");
			statement.setString(1, id.toString());
			var resultSet = statement.executeQuery();
			
			Cliente cliente = null;
			
			if(resultSet.next()) {
				
				cliente = new Cliente();
				
				cliente.setId(UUID.fromString(resultSet.getString("id")));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setDataCadastro(new Date(resultSet.getTimestamp("datacadastro").getTime()));
			}
			
			connection.close();
			
			return cliente;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
