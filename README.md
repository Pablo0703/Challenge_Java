# Challenge 2025 - Java Advance

## Disciplina

**Java Advance** — Professor: Marcel Stefan Wagner

---

## Grupo

* Nome: Diego Santos Cardoso  
* RM: 558711

* Nome: Pablo Lopes Doria de Andrade  
* RM: 556834

* Nome: Vinicius Leopoldino de Oliveira  
* RM: 557047

---

## Descrição do Projeto

API RESTful desenvolvida em Java com Spring Boot e Oracle Database, contendo 12 entidades relacionadas ao gerenciamento logístico da empresa Mottu. O projeto adota uma arquitetura baseada em camadas, com foco em boas práticas como uso exclusivo de DTOs com validações via Jakarta Bean Validation, tratamento de erros centralizado com `ResponseStatusException`, e persistência com Spring Data JPA.

---

## Estrutura do Projeto

ChallengeMottu/
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
└── ChallengeMottuApplication.java


---

## Tecnologias Utilizadas

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Oracle Database (via Oracle SQL Developer)
* Jakarta Bean Validation
* Docker (opcional)

---

## Entidades Implementadas (12)

* Endereco
* Filial
* HistoricoLocalizacao
* LocalizacaoMoto
* Motociclista
* Moto
* NotaFiscal
* Patio
* StatusMoto
* StatusOperacao
* TipoMoto
* ZonaPatio

Cada entidade foi implementada com:

* Classe DTO com validações (Bean Validation)
* Classe Entity (JPA)
* Repository estendendo JpaRepository
* Service com métodos assíncronos e tratamento de erro
* Controller com rotas: GET geral, GET por ID, GET com filtro, POST, PUT, DELETE

---

## Instruções de Execução Local

### Requisitos

* Java 21
* Maven 3.9+
* Oracle XE ou acesso ao banco Oracle (FIAP)
* Docker (opcional)

### Configuração do `application.properties`

```properties
spring.application.name=challenge-mottu

spring.datasource.url=jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.username=rm558711
spring.datasource.password=fiap24

spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
