
Sistema Automotivo 🚗

Análise e Desenvolvimento de Sistemas - UniFECAF  
Disciplina: Object Oriented Programming
Aluno: Vinicius Rabelo Barbosa

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

📝 **Descrição do Projeto**

O Sistema Automotivo foi desenvolvido com o objetivo de gerenciar o estoque de veículos de uma concessionária. Permite o cadastro de veículos, consulta por filtros, atualizações e remoção de registros. Este projeto reflete desafios reais enfrentados no setor automotivo, aplicando conceitos de Programação Orientada a Objetos e desenvolvimento de APIs REST.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

✅ **Requisitos Funcionais**

- Cadastro de veículos com informações: modelo, marca, ano, cor, preço, quilometragem e status.
- Consulta e filtros por marca, modelo, preço, ano e status.
- Atualização de informações de veículos.
- Remoção de veículos do estoque.
- Persistência de dados utilizando PostgreSQL.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🛠 **Tecnologias Utilizadas**

- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- PostgreSQL
- Maven
- IntelliJ IDEA

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🏗 **Estrutura do Projeto e Diagrama de Classes**

```
+----------------------+
|     Veiculo          |
+----------------------+
| - id: Long           |
| - modelo: String     |
| - marca: String      |
| - ano: int           |
| - cor: String        |
| - preco: BigDecimal  |
| - quilometragem: int |
| - status: String     |
+----------------------+

+----------------------+
| VeiculoRepository    |
+----------------------+
| extends JpaRepository|
+----------------------+

+----------------------+
| VeiculoService       |
+----------------------+
| +getAll()            |
| +getById(Long)       |
| +create(Veiculo)     |
| +update(Long, Veiculo)|
| +delete(Long)        |
+----------------------+

+----------------------+
| VeiculoController    |
+----------------------+
| +getAll()            |
| +getById(Long)       |
| +create(Veiculo)     |
| +update(Long, Veiculo)|
| +delete(Long)        |
+----------------------+
```

Estrutura condizente com o código-fonte do projeto:
```
src/
 └── main/
     └── java/
         └── com/concessionaria/sistemaautomotivo/
             ├── controller/
             │   └── VeiculoController.java
             ├── model/
             │   └── Veiculo.java
             ├── repository/
             │   └── VeiculoRepository.java
             ├── service/
             │   └── VeiculoService.java
             └── SistemaautomotivoApplication.java
     └── resources/
         ├── application.properties
```

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🗄 **Configuração do Banco de Dados**

Configurações no arquivo `application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/sistema_automotivo
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

⚠ Importante: A base de dados `sistema_automotivo` precisa existir no PostgreSQL.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🚀 **Execução da Aplicação**

1. Certifique-se de que o banco de dados PostgreSQL esteja rodando.
2. Execute a aplicação pelo IntelliJ IDEA ou usando o comando:
```
./mvnw spring-boot:run
```
3. A API ficará disponível em `http://localhost:8080/veiculos`.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🧪 **Testes Realizados**

Os endpoints foram testados utilizando o Postman:

| Método | Endpoint          | Descrição                  | Status |
|--------|-------------------|----------------------------|--------|
| GET    | /veiculos         | Lista todos os veículos    | ✅ OK  |
| GET    | /veiculos/{id}    | Busca veículo por ID       | ✅ OK  |
| POST   | /veiculos         | Cria novo veículo          | ✅ OK  |
| PUT    | /veiculos/{id}    | Atualiza veículo existente | ✅ OK  |
| DELETE | /veiculos/{id}    | Remove um veículo          | ✅ OK  |

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

🎯 **Aprendizados**

Durante o desenvolvimento deste projeto, foram reforçados conceitos essenciais:
- Aplicação de Programação Orientada a Objetos (POO).
- Implementação de padrões RESTful.
- Utilização do Spring Boot com JPA e banco de dados relacional.
- Tratamento de erros HTTP.
- Testes de API com Postman.
- Organização e estruturação de um projeto realista seguindo boas práticas de desenvolvimento.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
