# 🟪 FemCloud API

**FemCloud API** is a RESTful API built with **Spring Boot** that lets you manage and explore quotes by **feminist and pioneering women** throughout history. It's designed as a learning project and a tribute to the words and ideas that inspired generations of women and men.

<br>


## 🚀 Project Purpose

This project helps you:

- Learn how to build a complete CRUD REST API using Spring Boot  
- Understand the MVC architecture (Controller – Service – Repository)  
- Connect a Spring Boot app to a **MySQL** database  
- Practice API testing with **Postman**  
- Promote historical and inspirational quotes from impactful women

<br>


## ✨ Thematic Focus

This API is dedicated to preserving and sharing **quotes by feminist thinkers, activists, and historical pioneers**.

Examples of influential women:

- **Simone de Beauvoir**  
- **Wu Zetian**  
- **Rosa Luxemburg**  
- **Audre Lorde**  
- **Christine de Pizan**  
- **Clara Campoamor**  
- **Aspasia of Miletus**  
- **Frida Kahlo**  
- **Angela Davis**  
- **Nana Asma’u**  
- **Olympe de Gouges**  
- **Virginia Woolf**  
- **Im Yunjidang**  
- **Malala Yousafzai**  
- **Qiu Jin**  
- **Dolores Ibárruri**  
- **Hypatia of Alexandria**

Quotes should reflect feminist thought, social change, human rights, or historical relevance.

<br>


## 🛠️ Technologies & Tools

- ✅ Java 21  
- ✅ Spring Boot  
- ✅ MySQL  
- ✅ IntelliJ IDEA  
- ✅ Postman  
- ✅ Git & GitHub  
- ✅ Trello (for task tracking)

<br>


## 🗂️ Project Structure

The project follows a clean **3-layer MVC architecture**:

```

com.femcloud\_api
│
├── controller      # Handles incoming HTTP requests
├── service         # Business logic
├── repository      # Data access (JPA)
├── model           # The Quote entity
└── exception       # Custom error handling

````

<br>


## 📋 Functional Requirements

- [x] View all quotes  
- [x] View a quote by ID  
- [x] Create a new quote  
- [x] Update an existing quote  
- [x] Delete a quote

<br>


## 🧾 Quote Entity Structure

```java
public class Quote {
    private Long id;
    private String text;
    private String author;
    private String year;
}
````
<br>

## 🔌 API Endpoints

| Method | Endpoint       | Description                |
| ------ | -------------- | -------------------------- |
| GET    | `/quotes`      | Get all quotes             |
| GET    | `/quotes/{id}` | Get a specific quote by ID |
| POST   | `/quotes`      | Add a new quote            |
| PUT    | `/quotes/{id}` | Update an existing quote   |
| DELETE | `/quotes/{id}` | Delete a quote             |

<br>


## 📦 Example JSON for Creating/Updating a Quote

```json
{
  "text": "I am not free while any woman is unfree, even when her shackles are very different from my own.",
  "author": "Audre Lorde",
  "year": 1981
}
```

<br>


## ⚠️ Error Handling

When a quote is not found by ID, the API responds with a structured JSON error and a `404` status code:

```json
{
  "timestamp": "2025-06-10T14:20:00",
  "status": 404,
  "error": "Not Found",
  "path": "/quotes/2"
}
```

This is handled via a custom exception `QuoteNotFoundException`.

<br>


## 🧪 Testing with Postman

1. Run the application in IntelliJ (`main()` method)
2. Use Postman to test all API endpoints
3. Ensure your MySQL database is running and configured
4. Update `application.properties` or `application.yml` with correct DB settings

<br>


## ✅ Non-Functional Requirements

* Clean MVC architecture
* Connection to MySQL database
* Clean and maintainable code
* Error handling with custom messages
* Manual API testing via Postman

<br>


## 💡 Possible Future Improvements

* Input validation using `@Valid`
* Pagination and search by author
* Swagger/OpenAPI documentation
* Spring Security authentication

<br>


## 🧠 What I Learned

* Building REST APIs with Spring Boot
* Use of `JpaRepository` for CRUD operations
* Structuring code using MVC principles
* Error handling using custom exceptions
* Testing endpoints with Postman

<br>


## 📁 Suggested Directory Structure

```
src/
├── main/
│   └── java/com/femcloudapi
│       ├── controller
│       ├── service
│       ├── repository
│       ├── model
│       └── exception
├── resources/
│   └── application.properties
└── test/
```

<br>


## 🙌 Created with ❤️ by Lizar22

FemCloud API is more than just a CRUD project — it's a tribute to feminist voices and an essential part of my Spring Boot learning journey, combining backend development practice with the creation of powerful, respectful software.

