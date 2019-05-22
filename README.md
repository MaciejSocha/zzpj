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
4. Create a database named zzpj (or other name, do what you want, but remember that database name is in url)
    
    a. I found sth wired. On Windows You set up username and pass during installation. On Linux password is not set, you must do it yourself.
    type: $sudo -i -u postgres then $psql and \password and set a password
    also default authentication type does not use passwd so you must edit pg_hba.conf and set in last column 'password'. To do it:
    type SHOW hba_file; in psql shell and edit file with given path. Change METHOD to password.
    
5. Change database credentials in src/main/resources/application.properties (change: spring.datasource.url, spring.datasource.username, spring.datasource.password) to Your local
    
        Default should be like: spring.datasource.url=jdbc:postgresql://localhost:5432/zzpj
                                spring.datasource.username=postgres
                                spring.datasource.password=root
                                (or other password you set at instalation)
6. Maven install
7. Run ZzpjApplication
8. Enter localhost:8080

    a. localhost:8080/create will create sample records in database
    
-----

RULES:

- First rule of the gitclub, don't talk about gitclub

- Second rule of the gitclub, don't talk about gitclub

- Use branches (master is automatic deploy on heroku)

- Name branches as tasks on github, first should be a number of issue (ex. 25_issue_name)

- DON'T use swear words in commit (and also in code)

- Use issues to manage tasks

