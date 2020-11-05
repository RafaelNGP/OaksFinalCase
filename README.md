# API Film Production System

This API has the functionality to register actors and directors, in order to filter searches. This filter is able to reduce the results for only the actors with the value, relevance, film genre and the available time required by the director.


### Prerequisites

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk15-downloads.htm) - Available on the Oracle website.
- IDE - Of your preference.

### Installing

- First, have Java and IDE correctly installed.
- Secondly download the [Git](https://github.com/RafaelNGP/OaksFinalCase) project and open it on ide.

## Swagger

- Make sure the project is running.
- open in your browser [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

![Swagger](https://github.com/RafaelNGP/OaksFinalCase/blob/developer/img/Swagger.png)

## Built With

* [Java](https://www.java.com/pt-BR/) - The programming language used.
* [Spring](https://spring.io/) - Tool framework.
* [Swagger](https://swagger.io/docs/) - Interface description language.
* [H2](https://www.h2database.com/html/main.html) - Database used 
```
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: sa
    password:
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
  h2:
    console:
```

## Versioning

- 1.0 - Single version

## Authors

[Elderlee Fortunato](https://github.com/elderleelfs)

[Juliana Lunguinho](https://github.com/JulianaLunguinho)

[Mateus Henrique](https://github.com/henriqss)

[Rafael Ferreira](https://github.com/RafaelNGP)

## Acknowledgments

[Rafael Pazini](https://www.linkedin.com/in/rflpazini/)

