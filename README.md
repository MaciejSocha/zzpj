# zzpj

Continuous Integration build status:

[![CircleCI](https://circleci.com/gh/MaciejSocha/zzpj/tree/master.svg?style=svg)](https://circleci.com/gh/MaciejSocha/zzpj/tree/master)

Automatic build from master on:

https://zzpj.herokuapp.com

-----
Stuff:
- Java 11 ✔️
- Spring Boot ✔️
- Maven ✔️
- Github ✔️
- CircleCi ✔️
- Heroku ✔️
- JUnit5 ✔️
- Database (Postgres) ✔️
- Lombok ✔️

-----

To run app:
1. Clone repo
2. Install Postgresql
3. Import as maven project using Java11 (JDK11)
4. Change database credentials in src/main/resources/application.properties (change: spring.datasource.url, spring.datasource.username, spring.datasource.password) to Your local
    
        Default should be like: spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
                                spring.datasource.username=postgres
                                spring.datasource.password=root
                                (or other password you set at instalation)
5. Maven install
6. Run ZzpjApplication
7. Enter localhost:8080

    a. localhost:8080/create will create sample records in database
    
-----

RULES:

- First rule of the gitclub, don't talk about gitclub

- Second rule of the gitclub, don't talk about gitclub

- Use branches (master is automatic deploy on heroku)

- DON'T use swear words in commit (and also in code)

- Use issues to manage tasks
