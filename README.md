# VUTTR - Very Useful Tools to Remember

Esta é uma aplicação Spring Boot para gerenciar uma lista de ferramentas com seus nomes, links, descrições e tags.

## Descrição do Projeto

[//]: # (Por favor, preencha esta seção com uma descrição mais detalhada do projeto.)

Este projeto é um desafio backend da Bossa Box. O objetivo é criar uma API REST simples para gerenciar ferramentas.

## Funcionalidades

*   Listar todas as ferramentas
*   Listar ferramentas por tag
*   Criar uma nova ferramenta
*   Deletar uma ferramenta

## Tecnologias Utilizadas

*   Java 21
*   Spring Boot
*   Maven
*   PostgreSQL
*   Flyway
*   Docker

## Começando

### Pré-requisitos

*   Java 21
*   Maven
*   Docker

### Executando a aplicação

1.  Clone o repositório:
    ```bash
    git clone <repository-url>
    ```
2.  Navegue até o diretório do projeto:
    ```bash
    cd vuttr
    ```
3.  Execute a aplicação usando Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
4.  A aplicação estará disponível em `http://localhost:3000`.

### Executando com Docker

1.  Inicie o banco de dados PostgreSQL:
    ```bash
    docker-compose up -d
    ```
2.  Construa a imagem Docker:
    ```bash
    docker build -t vuttr:latest .
    ```
3.  Execute o container da aplicação:
    ```bash
    docker run -p 3000:3000 vuttr:latest
    ```
4.  A aplicação estará disponível em `http://localhost:3000`.

5.  Para parar o banco de dados PostgreSQL:
    ```bash
    docker-compose down
    ```

## Endpoints da API

A documentação da API está disponível em `http://localhost:3000/swagger-ui.html`.

*   `GET /tools`: Obter todas as ferramentas.
*   `GET /tools?tag={tag}`: Obter ferramentas por tag.
*   `POST /tools`: Criar uma nova ferramenta.
*   `DELETE /tools/{id}`: Deletar uma ferramenta pelo ID.
