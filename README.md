# Donezo API

![Version](https://img.shields.io/badge/version-0.0.1--SNAPSHOT-blue)
![License](https://img.shields.io/badge/license-MIT-green)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen)

## 📝 Descrição

Donezo é uma API RESTful para gerenciamento de tarefas desenvolvida com Spring Boot. A aplicação permite aos usuários criar, visualizar e atualizar tarefas, organizando-as com datas de início e término.

## 🚀 Funcionalidades

- Gerenciamento completo de tarefas (CRUD)
- Autenticação e autorização de usuários
- Criação de tarefas com datas de início e término
- Validações de datas
- Proteção de tarefas por usuário

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.2**
- **Spring Data JPA** - Para persistência de dados
- **H2 Database** - Banco de dados em memória para desenvolvimento e testes
- **BCrypt** - Para criptografia de senhas
- **Lombok** - Para redução de código boilerplate
- **Maven** - Gerenciamento de dependências
- **Docker** - Containerização

## 📦 Estrutura do Projeto

```
donezo/
├── .mvn/wrapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── matheusmaciel/
│   │   │           └── donezo/
│   │   │               ├── errors/
│   │   │               ├── filter/
│   │   │               ├── task/
│   │   │               ├── user/
│   │   │               ├── utils/
│   │   │               └── DonezoApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── java/
│           └── com/
│               └── matheusmaciel/
│                   └── donezo/
├── .gitattributes
├── .gitignore
├── Dockerfile
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## 🔧 Instalação e Execução

### Pré-requisitos

- Java 21+
- Maven 3.8+
- Docker (opcional)

### Executando localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/srmatheusmaciel/donezo.git
   cd donezo
   ```

2. Compile o projeto com Maven:
   ```bash
   ./mvnw clean install
   ```

3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

4. A API estará disponível em `http://localhost:8080`


## 📚 API Endpoints

### Usuários

- `POST /users/` - Registrar novo usuário

### Tarefas

- `POST /tasks/` - Criar nova tarefa
- `GET /tasks/` - Listar todas as tarefas do usuário autenticado
- `PUT /tasks/{id}` - Atualizar tarefa existente

## 📊 Modelos de Dados

### Usuário (UserModel)

```json
{
  "id": "UUID",
  "username": "string",
  "password": "string (encrypted)",
  "name": "string",
  "createdAt": "datetime"
}
```

### Tarefa (TaskModel)

```json
{
  "id": "UUID",
  "description": "string",
  "title": "string",
  "priority": "string",
  "startAt": "datetime",
  "endAt": "datetime",
  "userId": "UUID",
  "createdAt": "datetime"
}
```

## 🔒 Segurança

A API implementa autenticação e proteção de rotas. As tarefas só podem ser visualizadas e modificadas pelo usuário que as criou.

As senhas dos usuários são armazenadas no banco de dados utilizando o algoritmo de hash BCrypt.

### Validações

- A data de início e término de uma tarefa deve estar no futuro
- A data de início deve ser anterior à data de término
- Apenas o usuário que criou a tarefa pode atualizá-la

## 🧪 Testes

Execute os testes automatizados com:

```bash
./mvnw test
```

Para relatórios de cobertura:

```bash
./mvnw verify
```

## 🔄 Configuração

As principais configurações da aplicação podem ser ajustadas no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:donezo
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=admin
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adicionando nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para detalhes.

## 👨‍💻 Autor

Matheus Maciel - [@srmatheusmaciel](https://github.com/srmatheusmaciel)

---

Desenvolvido com ❤️ usando Spring Boot
