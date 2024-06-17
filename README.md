# 📚 Projeto Design Patterns Java Spring API Rest

Este projeto é uma aplicação de exemplo que utiliza Java com Spring Boot para criar uma API REST, demonstrando a implementação de alguns padrões de projeto (Design Patterns). O projeto inclui operações CRUD (Create, Read, Update, Delete) para entidades `Aluno`, `Curso` e `Endereco`.

## 🛠️ Tecnologias Utilizadas

- Java 11 ☕
- Spring Boot 🌱
- Spring Data JPA 📊
- H2 Database 🗄️
- Feign Client 🔗
- ViaCEP API 🏢

## 🗂️ Estrutura do Projeto

### 📌 Controllers

- **AlunoRestController**: Controller responsável por gerenciar as operações relacionadas à entidade `Aluno`.
- **CursoRestController**: Controller responsável por gerenciar as operações relacionadas à entidade `Curso`.

### ⚙️ Services

- **AlunoService**: Interface que define os métodos para gerenciar alunos.
- **AlunoServiceImpl**: Implementação da interface `AlunoService` que contém a lógica de negócio para as operações com alunos.

### 🗄️ Repositories

- **AlunoRepository**: Interface que estende `CrudRepository` para a entidade `Aluno`.
- **CursoRepository**: Interface que estende `CrudRepository` para a entidade `Curso`.
- **EnderecoRepository**: Interface que estende `CrudRepository` para a entidade `Endereco`.

### 📋 Entidades

- **Aluno**: Entidade que representa um aluno, com atributos como `id`, `nome`, `cpf`, `endereco` e `curso`.
- **Curso**: Entidade que representa um curso, com atributos como `id`, `nomeCurso`, `materiaCurso`, `dataFinalizacaoCurso` e `dataInicioCurso`.
- **Endereco**: Entidade que representa um endereço, com atributos como `cep`, `logradouro`, `complemento`, `bairro`, `localidade`, `uf`, `ibge`, `gia`, `ddd` e `siafi`.

### 🔍 Outros

- **ViaCepService**: Interface Feign Client para integrar com a API ViaCEP e consultar endereços a partir de um CEP.

## 🔗 Endpoints da API

### 🧑‍🎓 Alunos

- **GET /alunos**: Retorna todos os alunos.
- **GET /alunos/{id}**: Retorna um aluno pelo ID.
- **POST /alunos**: Insere um novo aluno.
- **PUT /alunos/{id}**: Atualiza um aluno existente pelo ID.
- **DELETE /alunos/{id}**: Deleta um aluno pelo ID.

### 📚 Cursos

- **GET /cursos/{id}**: Retorna um curso pelo ID.
- **POST /cursos**: Insere um novo curso.
