Claro! Aqui o conteúdo completo do README pra você copiar e colar direto:

```markdown
<div align="center">

# 🏫 Reserva de Salas

**Sistema web para reservar salas de aula, reunião ou laboratório**

[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen?logo=spring)](https://spring.io/projects/spring-boot)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1-green)](https://www.thymeleaf.org)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?logo=mysql)](https://www.mysql.com)
[![Maven](https://img.shields.io/badge/Maven-3.9-red?logo=apachemaven)](https://maven.apache.org)

</div>

---

## 📋 Sobre o Projeto

Este é um sistema completo de **reserva de salas** desenvolvido com **Spring Boot** e **Java 21**. O sistema permite cadastrar salas, usuários e realizar reservas com validação automática de conflitos de horários.

> 🎯 Projeto acadêmico desenvolvido para praticar conceitos de desenvolvimento web com Spring Boot, JPA/Hibernate, Thymeleaf e MySQL.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|---|---|---|
| **Java** | 21 | Linguagem principal |
| **Spring Boot** | 3.4.2 | Framework web |
| **Spring Data JPA** | 3.4.2 | Acesso ao banco de dados |
| **Thymeleaf** | 3.1 | Motor de templates HTML |
| **MySQL** | 8.0 | Banco de dados relacional |
| **Maven** | 3.9+ | Gerenciamento de dependências |
| **Lombok** | 1.18 | Redução de código boilerplate |

---

## ⚙️ Funcionalidades

### ✅ CRUD Completo
- 📍 **Salas** — Cadastrar, listar, editar e excluir salas

<img width="1905" height="587" alt="image" src="https://github.com/user-attachments/assets/3a427ea8-db24-44a6-be89-d5d15a638e7c" />

- 👤 **Usuários** — Cadastrar, listar, editar e excluir usuários

<img width="1901" height="197" alt="image" src="https://github.com/user-attachments/assets/00b9c223-7af8-429f-9294-f5767507ab3a" />

- 📅 **Reservas** — Criar, listar e cancelar reservas

<img width="1900" height="727" alt="image" src="https://github.com/user-attachments/assets/62da9a02-6de8-47d6-ac5f-36d0524dfc08" />


### 🔍 Busca e Filtros
- Buscar salas por **nome** (parcial, case-insensitive)
- Filtrar reservas por **sala**

### 🛡️ Validações
- ✅ Validação de formulários (campos obrigatórios)
- ✅ **Conflito de horários** — impede duas reservas na mesma sala em horários sobrepostos
- ✅ Validação no navegador com **JavaScript** (horário fim deve ser depois do início)
- ✅ Tratamento amigável de erros

---

## 🗂️ Estrutura do Projeto

```
reserva/
├── src/main/java/com/salas/reserva/
│   ├── ReservaApplication.java
│   ├── controller/          # Controllers MVC
│   ├── model/               # Entidades JPA
│   ├── repository/          # Interfaces Spring Data JPA
│   ├── service/             # Regras de negócio
│   └── dto/
├── src/main/resources/
│   ├── static/css/          # Estilos CSS
│   ├── templates/           # Páginas Thymeleaf
│   │   ├── salas/
│   │   ├── usuarios/
│   │   └── reservas/
│   └── application.properties
├── pom.xml
└── README.md
```

---

## 🛠️ Como Executar

### Pré-requisitos
- [Java 21](https://www.oracle.com/java/technologies/downloads/#java21) instalado
- [MySQL 8.0](https://dev.mysql.com/downloads/) rodando
- [Maven](https://maven.apache.org/download.cgi) instalado

### Passo a passo

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/reserva-salas.git
   cd reserva-salas
   ```

2. **Configure o banco de dados**
   
   Edite o arquivo `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/reserva_salas?createDatabaseIfNotExist=true
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   ```

3. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse no navegador**
   ```
   http://localhost:8080/salas
   ```

---

## 🔌 Endpoints Testados no Postman

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/salas` | Lista todas as salas |
| `GET` | `/salas?nome=aula` | Busca salas por nome |
| `POST` | `/salas` | Cadastra nova sala |
| `GET` | `/salas/editar/{id}` | Edita sala |
| `GET` | `/salas/excluir/{id}` | Exclui sala |
| `GET` | `/usuarios` | Lista usuários |
| `POST` | `/usuarios` | Cadastra usuário |
| `GET` | `/reservas` | Lista reservas |
| `GET` | `/reservas?salaId=1` | Filtra reservas por sala |
| `POST` | `/reservas` | Cria reserva (com validação de conflito) |

---

## 📐 Regras de Negócio

- Uma sala não pode ter duas reservas no mesmo horário
- Horário de fim deve ser **posterior** ao horário de início
- Campos obrigatórios são validados no formulário
- Email e matrícula de usuários devem ser únicos

---

## 👨‍💻 Autor

**Davi Ocker**

---

<div align="center">

⭐ **Se este projeto te ajudou, deixe uma estrela!** ⭐

</div>
