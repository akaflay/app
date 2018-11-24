# Application
This project has basic setup that you can use to create a spring boot application using Jersey , Hikaricp , Hibernate with Spring Config Server with circuit breaker.
This project also has some basic exemples of how we can create filter for all the request comming to the server, AOP programming, MultiThreading using ExecutorService, Exception handling.
This project also has some basic usage of Java8 Features as CompletableFuture.This project also contains a standart method of seperating different layers of the server.
This project also has Solutions to the data structure and algorithm questions.

## Requirements
1. Java 8. For windows users setup Java https://www.mkyong.com/java/how-to-set-java_home-on-windows-10/
2. Maven. For windows users setup maven https://www.mkyong.com/maven/how-to-install-maven-in-windows/
3. MySql Database Server.

## Running Project.
1. Build the project using mvn clean install command.
2. Change the configuration of the DB in the application.properties in the src/main/resource folder or use the config server(https://github.com/akaflay/config-server)
3. mvn spring-boot:run

## EndPoint 
1. GET http://localhost:8080/endpoints/first
2. GET http://localhost:8080/endpoints/second
3. GET http://localhost:8080/endpoints/curcitbreaker
4. GET http://localhost:8080/students/
5. GET http://localhost:8080/students/{student-id}
6. POST http://localhost:8080/students/ with payload { "First Name":"Your First Name", "Last Name":"Your Last Name" }
5. DELETE http://localhost:8080/students/{stident-id}

## Circuit Breaker
To Enable Curcuit breaker stop the config server and make a GET request to http://localhost:8080/endpoints/curcitbreaker

## Questions and Concerns
https://better-coder.slack.com/


