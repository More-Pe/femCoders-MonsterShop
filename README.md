# 🛒 MonsterShop Backend

Welcome to **MonsterShop**, an e-commerce backend built with Java, Spring Boot, and MySQL!  
This project provides RESTful APIs for managing products and reviews, designed to be used with a modern frontend (e.g., React + Vite).

## 🚀 Features

- **Product Management**: Create, read, update, and delete products.
- **Review System**: Add and fetch reviews for products.
- **Validation**: Input validation for all endpoints.
- **CORS Configured**: Ready for local frontend development.
- **Environment Variables**: Secure database configuration using dotenv.

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Maven**
- **MySQL**
- **JPA/Hibernate**
- **Jakarta Validation**
- **Dotenv for Java**

## ⚙️ Setup & Run

### 1. 🐬 Install MySQL

Make sure you have MySQL running locally.  
Create a database for the project:

```sql
mysql -u root -p
CREATE DATABASE monster_shop;
```

### 2. 📦 Clone the Repository
```shell
git clone https://github.com/More-Pe/femCoders-MonsterShop
cd femCoders-MonsterShop
```

### 3. 🔑 Configure Environment Variables
Create a .env file in the project root with your database credentials:
```shell
DB_URL=jdbc:mysql://localhost:3306/monster-shop
DB_USER=your_mysql_user
DB_PASSWORD=your_mysql_password
```
Note:
The backend uses java-dotenv to load these variables.

### 4. 🧰 Install Dependencies
Make sure you have Maven installed.
Then, install dependencies:

```shell
mvn clean install
```

### 5. 🚀 Run the Application
```shell
mvn spring-boot:run
```

### 6. 🌐 Access the API
Open your browser or API client (like Postman) and navigate to:
```
http://localhost:8080/api/products
```
## 🌐 API Endpoints
### Products

| Method | Endpoint                | Description                  |
|--------|-------------------------|------------------------------|
| GET    | `/api/products`         | List all products            |
| GET    | `/api/products/{id}`    | Get product by ID            |
| POST   | `/api/products`         | Add a new product            |
| PUT    | `/api/products/{id}`    | Update a product             |
| DELETE | `/api/products/{id}`    | Delete a product             |

### Reviews

| Method | Endpoint                   | Description                           |
|--------|----------------------------|---------------------------------------|
| POST   | `/api/reviews`             | Add a review to a product             |
| GET    | `/api/reviews/{productId}` | Get all reviews for a product         |

## 🔗 Connecting Frontend to Backend
### Prerequisites

1. **Backend running:** Make sure your Spring Boot backend is running on http://localhost:8080

2. **CORS configured:** The backend is already configured to accept requests from http://localhost:5173 (default Vite port). You can change this in src/main/java/com/example/monsterShop/config/CorsConfig.java.

3. **Frontend running:** Ensure your frontend is running on http://localhost:5173

#### You can try the frontend at https://github.com/More-Pe/femCoders-monster-ecommerce-front