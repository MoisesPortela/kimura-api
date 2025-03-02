# API Rest Projeto Kimura

## Descrição

Este projeto é uma API REST desenvolvida para o sistema Kimura. A API fornece funcionalidades de CRUD para gerenciar pessoas e funcionalidades de autenticação para o sistema, como cadastro, atualização, detalhamento e exclusão de registros, bem como login.

### Tecnologias Utilizadas

- **Java**: Versão 17
- **Spring Boot**: Versão 3.4.1
- **MySQL**: Conector para interação com o banco de dados MySQL
- **Flyway**: Para controle de versão do banco de dados
- **Spring Security**: Para segurança e autenticação via JWT
- **Lombok**: Para reduzir o boilerplate de código
- **Springdoc OpenAPI**: Documentação da API no padrão OpenAPI

---

## Requisitos

- Java 17 ou superior
- Maven 3.8 ou superior
- MySQL 8.0 ou superior

---

## Dependências Principais

As principais dependências do projeto estão especificadas no arquivo `pom.xml`. Abaixo estão algumas delas:

- `spring-boot-starter-web`: Para criação de aplicações web RESTful.
- `spring-boot-starter-data-jpa`: Para operações com banco de dados.
- `spring-boot-starter-security`: Para autenticação e autorização.
- `springdoc-openapi-starter-webmvc-ui`: Para geração da documentação OpenAPI e Swagger UI.
- `lombok`: Para gerar getters, setters e outros métodos automaticamente.
- `flyway-core` e `flyway-mysql`: Para migrações do banco de dados.
- `java-jwt`: Para manipulação de tokens JWT.

---

## Endpoints Principais

### Pessoas

1. **Listar Pessoas**
   - **GET** `/pessoas`
   - Parâmetros: `pageable` (query)

2. **Cadastrar Pessoa**
   - **POST** `/pessoas`
   - Corpo da requisição: `DadosCadastrarPessoa`

3. **Atualizar Pessoa**
   - **PUT** `/pessoas`
   - Corpo da requisição: `DadosAtualizarPessoa`

4. **Detalhar Pessoa**
   - **GET** `/pessoas/{id}`
   - Parâmetro de caminho: `id`

5. **Deletar Pessoa**
   - **DELETE** `/pessoas/{id}`
   - Parâmetro de caminho: `id`

### Autenticação

1. **Efetuar Login**
   - **POST** `/login`
   - Corpo da requisição: `DadosAutenticacao`

---

## Documentação da API

A documentação completa da API está disponível nos seguintes links:

- [JSON da Documentação OpenAPI](http://localhost:8080/v3/api-docs)
- [Swagger UI](http://localhost:8080/swagger-ui/index.html#/)

---

## Configuração do Banco de Dados

Para conectar ao banco de dados MySQL, edite as configurações no arquivo `application.properties` ou `application.yml`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.flyway.enabled=true
```

---

## Execução do Projeto

1. Clone este repositório.
2. Certifique-se de que o MySQL está configurado e em execução.
3. Execute o seguinte comando no terminal para compilar e iniciar a aplicação:

```bash
mvn spring-boot:run
```

---

## Licença

Este projeto está licenciado sob a [Licença Apache 2.0](http://voll.med/api/licenca).

---

## Contato

Para mais informações ou relatório de problemas, entre em contato com o time Backend:

- **Email**: msportela2@hotmail.com
- **WhatsApp**: [Clique aqui para entrar em contato](https://api.whatsapp.com/send/?phone=61986210645&text=Tenho+perguntas+sobre+a+API+kimura&type=phone_number&app_absent=0)

@TODO:
- implementar endereço
- implementar foto
- implementar doc
- implementar exéirencia profissional