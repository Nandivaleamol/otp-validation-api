# otp-validation-api
Springboot MVC Web Application

# Introduction
This is a Java Spring Boot MVC application that uses a MySQL database and several Spring libraries, 
including Spring Boot, Spring Data JPA, Lombok, and Spring Security. The application includes 
three REST APIs that can be accessed through a Thymeleaf template engine-based HTML page. 
The three APIs are used to send an OTP, validate an OTP, and manage user profiles.

# Technologies
1. ava - Programming language used for the application
2. Spring Boot - Framework used for building the application
3. Spring Data JPA - Library used for database access
4. MySQL - Database used for storing application data
5. Lombok - Library used for reducing boilerplate code
6. Spring Security - Library used for user authentication and authorization
7. Thymeleaf - Template engine used for rendering the HTML page

# Implementation

1. Set up the project using the Spring Initializr with dependencies for Spring Boot, Spring Data JPA, Lombok, Spring Security, and Thymeleaf.

2. Create the MySQL database and configure the application to connect to it.

3. Create the User entity with the necessary fields, including name, email, password, and OTP.

4. Use Lombok annotations to generate getters, setters, constructors, and other boilerplate code.

5. Create the UserRepository interface that extends the Spring Data JPA Repository interface to perform CRUD operations on the User entity.

6. Implement the OTP Service with the functionality to generate, send, and validate OTPs.

7. Implement the User Service with the functionality to create, read, update, and delete user profiles.

8. Create the three REST APIs using Spring Boot annotations. The APIs include:
  a. An OTP send API that sends an OTP to the user's email.
  b. An OTP validate API that validates the OTP entered by the user.
  c. A user profile API that allows users to create, read, update, and delete their profiles.

9. Use Spring Security to secure the APIs and the HTML page with JWT token.

10. Use Thymeleaf to create an HTML page that allows users to interact with the three REST APIs.

# Conclusion
This Java Spring Boot MVC application with a MySQL database, Spring Boot, Spring Data JPA, Lombok, Spring Security, 
and Thymeleaf provides a solid foundation for building secure and scalable web applications. The REST APIs allow users 
to manage their profiles and validate OTPs, and the HTML page provides an easy-to-use interface for interacting with the APIs.

