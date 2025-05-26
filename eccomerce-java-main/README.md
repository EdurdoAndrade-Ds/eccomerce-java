# 📦 E-Commerce Microservices Project

Este repositório contém todos os microserviços do nosso projeto de e-commerce, desenvolvidos com Spring Boot.

## 🚧 Estrutura do Projeto

```
ecommerce-microservices/
├── auth-service/
├── product-service/
├── order-service/
├── payment-service/
├── notification-service/
├── api-gateway/
├── service-registry/
├── docker-compose.yml
└── README.md
```

Cada pasta representa um microserviço independente.

---

## 👨‍💻 Como Contribuir

### 🔁 Clonando o repositório
```bash
git clone https://github.com/EdurdoAndrade-Ds/eccomerce-java.git
cd ecommerce-microservices
```

### 📁 Criando seu serviço
1. Navegue até a raiz do projeto.
2. Crie sua pasta com o nome do serviço (`auth-service`, `payment-service`, etc).
3. Use o Spring Initializr com os seguintes padrões:
   - Java 17
   - Maven
   - Spring Boot 3.x
   - Dependências básicas: Spring Web, Spring Data JPA, Lombok, etc.

### 📦 Organização de pacotes 
```
src/main/java/com/ecommerce/<servico>/
├── controller
├── service
├── repository
├── model
└── dto
```

### 📃 Padrões
- Use **inglês** para nome de classes, variáveis e endpoints.
- Siga os mesmos nomes de campos entre serviços onde aplicável (ex: `userId`, `productId`).
- Use JSON como padrão de comunicação entre serviços.
- Documente os endpoints com Swagger (Springfox ou Springdoc OpenAPI).

---

## 🛠 Tecnologias

- Java 17
- Spring Boot
- Spring Security (Auth)
- JWT
- Spring Cloud Gateway (API Gateway)
- Eureka Server (Service Discovery)
- Docker / Docker Compose
- RabbitMQ (Notificações)
- MYSQL / H2

---

## 🧪 Testes

Cada serviço deve conter:
- Testes unitários (JUnit)
- Testes de integração (Postman ou RestAssured)
- Swagger para documentação dos endpoints

---

## 🧠 Responsáveis

| Serviço              | Responsável    |
|----------------------|----------------|
| Auth Service         | Jose           |
| Product Service      | Kaique         |
| Order Service        | Kosta          |
| Payment Service      | Dudu ⚡        |
| Notification Service | Iza            |
| API Gateway / Eureka | Fofinho        |
| Integração/Testes    | Maria Luiza    |

---

## 🗓️ Organização

- ✅ Fase 1: Estrutura dos serviços e comunicação básica
- ✅ Fase 2: Segurança e validação com JWT
- 🔄 Fase 3: Integração entre serviços e testes
- 🧪 Fase 4: Docker Compose + Deploy local
- 📖 Fase 5: Documentação final + apresentação

---

## ✅ Checklist Inicial

- [ ] Criar estrutura de pastas
- [ ] Criar os projetos Spring Boot
- [ ] Subir Eureka e Gateway
- [ ] Garantir que todos os serviços estão se registrando
- [ ] Definir os contratos de comunicação entre serviços
#
