# API Clientes

#### Sobre o projeto:
API RESTful desenvolvida com Spring Boot, oferecendo um CRUD para o gerenciamento de clientes.

### Tecnologias utilizadas:
* Java
* Spring Boot
* Maven
* MySQL
* Bean Validation
* Swagger

## Endpoints:
| Método | Endpoint              | Descrição                   |
|--------|-----------------------|-----------------------------|
| POST   | `/api/clientes`       | Cadastra um novo cliente    |
| GET    | `/api/clientes`       | Consulta todos os clientes  |
| GET    | `/api/clientes/{id}`  | Consulta um cliente por ID  |
| PUT    | `/api/clientes/{id}`  | Atualiza um cliente         |
| DELETE | `/api/clientes/{id}`  | Remove um cliente           |

### Exemplo de requisição:
```json
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "nome": "string",
  "email": "string",
  "telefone": "string",
  "dataCadastro": "2024-11-27T00:08:58.766Z"
}
```

## Estrutura do projeto:
```plaintext
com.example.demo
├── application
│   └── controllers         # Controladores REST
├── domain
│   ├── models              # Entidades e objetos de domínio
│   │   ├── dtos
│   │   └── entities
│   └── services            # Lógicas de domínio
│       ├── impl            
│       └── interfaces      
├── infrastructure          # Camada de infraestrutura 
│   ├── configurations      
│   ├── factories
│   └── configurations      
└── ApiClientesApplication.java
```

## Instalação e execução:

#### Requisitos:
- Java 21 ou superior
- Spring Boot 3.3.5
- MySQL

#### 1. Criação do banco de dados MySQL

```sql
CREATE DATABASE bdApiClientes;

USE bdApiClientes;

CREATE TABLE cliente(
	id  CHAR(36)  PRIMARY KEY,
	nome  VARCHAR(100)  NOT NULL,
	email  VARCHAR(100)  NOT NULL,
	telefone  VARCHAR(11)  NOT NULL,
	datacadastro  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
);

DESC cliente;
```

#### 2. Clone o repositório:
```bash
   git clone https://github.com/samuelmsilva2v/apiClientes.git
   cd apiClientes
```

#### 3. Executando a aplicação:
```bash
./mvnw spring-boot:run
```

#### 4. Acesse a aplicação:
  - Documentação da API: http://localhost:8080/swagger-ui/index.html

### Autor
- Samuel Maciel da Silva
  - [LinkedIn](https://www.linkedin.com/in/samuelmsilva2v/)
  - [E-mail](mailto:samuelmsilva@outlook.com.br)

