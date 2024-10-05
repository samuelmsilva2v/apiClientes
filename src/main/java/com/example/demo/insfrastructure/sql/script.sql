# Criando o banco de dados
CREATE DATABASE bdApiClientes;


# Acessando o banco de dados
USE bdApiClientes;


# Criando a tabela de clientes no banco de dados
CREATE TABLE cliente(
	id				CHAR(36)		PRIMARY KEY,
	nome			VARCHAR(100)	NOT NULL,
	email			VARCHAR(100)	NOT NULL,
	telefone		VARCHAR(11)		NOT NULL,
	datacadastro	TIMESTAMP		DEFAULT CURRENT_TIMESTAMP
);

# Visualizar a estrutura da tabela
DESC cliente;
