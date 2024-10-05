package com.example.demo.domain.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ClienteRequestDto {

	@Size(min = 6, max = 100, message = "O nome do cliente deve ter entre 6 e 100 caracteres.")
	@NotEmpty(message = "O nome do cliente é obrigatório.")
	private String nome;
	
	@Email(message = "Digite um e-mail válido (user@email.com).")
	@Size(min = 6, max = 100, message = "O e-mail do usuário deve ter entre 6 e 100 caracteres.")
	@NotEmpty(message = "O e-mail do cliente é obrigatório.")
	private String email;
	
	@Size(min = 10, max = 11, message = "Digite um número de telefone válido, deve ter 10 ou 11 caracteres.")
	@NotEmpty(message = "O telefone do cliente é obrigatório.")
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
