# Ngx-Spring-Starter

Spring Boot + Angular 5 starter project.

Goals:
* Start server and client with one command
* Deploy the app with one command


### How to use

* To run in watch mode use: ```sh run_dev.sh```
  * To access app: http://localhost:4200
  * To access API: http://localhost:8080
  * Don't need CORS because the Angular's proxy will redirect to server.


* To generate the UberJar: ```mvn clean install```
