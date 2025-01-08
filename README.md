# Challenge Foro Hub - API REST

Este proyecto es una implementación de un foro desarrollado con **Java** y **Spring Boot**, donde los usuarios pueden crear tópicos para plantear dudas o sugerencias, y responder a los mismos dentro de una comunidad.

---

## 🌟 Características principales

### 📝 Gestión de tópicos:
- Crear, listar, buscar por ID, actualizar y eliminar tópicos.

### 🔒 Autenticación y autorización:
- Comprobación de contraseñas hasheadas almacenadas en la base de datos.
- Uso de **JWT (JSON Web Tokens)** para proteger y asegurar el acceso a los endpoints.

### 💾 Persistencia de datos:
- **MySQL** como base de datos.
- Migraciones gestionadas con **Flyway**.

---

## 🛠️ Tecnologías utilizadas

- **Lenguaje**: Java 17  
- **Frameworks**:
  - Spring Boot 3
  - Spring Data JPA
  - Spring Security
  - Spring Validation  
- **Base de datos**: MySQL  

### Herramientas adicionales:
- **Flyway**: Control de versiones de la base de datos.  
- **Lombok**: Reducción de código repetitivo.  
- **BCrypt**: Para hashear contraseñas de manera segura.  

---

## 🔗 Endpoints principales

### 📌 Tópicos
- **Listar tópicos**:  
  `GET /topicos`  

- **Buscar tópico por ID**:  
  `GET /topicos/{id}`  

- **Buscar tópicos por palabras clave**:  
  `POST /topicos/busqueda`  

- **Crear un tópico**:  
  `POST /topicos`  

- **Actualizar un tópico**:  
  `PUT /topicos/{id}`  

- **Eliminar un tópico**:  
  `DELETE /topicos/{id}`  

### 🔐 Autenticación
- **Generar token JWT**:  
  `POST /login`  
