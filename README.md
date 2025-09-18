`` Generated via abhiPyScriptSummaryGenerator``
# Spring Security JWT Authentication

This repository provides a sample implementation of **JWT Authentication** using **Spring Security**. It demonstrates how to secure a Spring Boot application with JWT tokens for stateless authentication. The key components include a custom **JWT filter**, **JWT service**, and **User Details Service**.

## Features
- **JWT Authentication**: Secure API endpoints using JWT tokens.
- **Stateless Authentication**: The application does not use session-based authentication, but instead uses JWTs to manage authentication.
- **Spring Security Integration**: Configured Spring Security with custom authentication mechanisms.
- **Dynamic Bean Retrieval**: Optionally retrieves beans dynamically from the application context.

## Key Components

### 1. **Security Configuration (`SecurityConfig.java`)**
   - Configures Spring Security for JWT-based authentication.
   - Disables CSRF protection and configures stateless session management.
   - Defines a custom **AuthenticationProvider** and **SecurityFilterChain**.
   - Manages the authentication manager bean for authenticating requests.

### 2. **JWT Filter (`JwtFilter.java`)**
   - A Spring filter (`OncePerRequestFilter`) that intercepts incoming HTTP requests to check for the `Authorization` header.
   - Extracts and validates the JWT token from the header, then authenticates the user if the token is valid.
   - Optionally uses **`ApplicationContext`** to dynamically retrieve beans like **`MyUserDetailsService`** to load user details for JWT validation.

### 3. **JWT Service (`JwtService.java`)**
   - Responsible for generating and validating JWT tokens.
   - Uses the **`io.jsonwebtoken`** library to create and parse JWT tokens.
   - Methods include `generateToken`, `validateToken`, and `extractUsername` to extract data from tokens.

### 4. **User Details Service (`MyUserDetailsService.java`)**
   - Implements **`UserDetailsService`** to load user-specific data by username for authentication.
   - The `loadByUsername` method retrieves user details from the database or other persistent storage.
   - The service is used in the `JwtFilter` to validate the extracted username from the JWT.

### 5. **User Model (`MainUser.java`)**
   - Defines the `MainUser` entity for user data.
   - Stores fields like `username`, `password`, and `id`.
   - Annotated with JPA annotations for persistence.

### 6. **Custom UserPrincipal (`UserPrinicipal.java`)**
   - Implements `UserDetails` to represent the authenticated user's details.
   - Provides methods like `getAuthorities`, `getUsername`, `getPassword`, etc., for Spring Security to handle authentication.

### 7. **User Registration and Login Controller (`MainUserController.java`)**
   - Provides `register` and `login` endpoints for user registration and authentication.
   - The `register` endpoint hashes user passwords and saves the user to the database.
   - The `login` endpoint authenticates users by verifying the JWT token and returns a success/failure message.

### 8. **Spring Boot Security Setup (`UserService.java` & `UserRepo.java`)**
   - **`UserService.java`** handles user-related operations like saving a user to the database.
   - **`UserRepo.java`** is a repository interface extending `JpaRepository` to interact with the user database.

### 9. **Application Context Configuration (optional)**
   - The **`ApplicationContext`** is manually injected and used to retrieve beans like `MyUserDetailsService` in the `JwtFilter` (though this is optional and typically not required in most cases).

---

## How to Run the Application

### Prerequisites
- **Java 21** or later
- **Maven** for building the project
- **Spring Boot** and **Spring Security** dependencies are handled via Maven.

### Steps
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo/spring-security-jwt.git

2. **Access the Application**:

The application will be running at http://localhost:8080.

You can register a new user via the /register endpoint and authenticate via the /login endpoint.
