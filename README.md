# API-Testing-Cucumber

This project uses BDD (Behavior Driven Development) and Cucumber framework to validate and perform health checks for endpoints used by a RESTful API developed by Spring Boot framework. 

API uses MongoDB to store data to personal db name -> bank-api-db

Used Maven to add dependencies such Spring.env -> to hide database connection configurations 

```xml
// pom.xml

<dependency>
  <groupId>me.paulschwarz</groupId>
  <artifactId>spring-dotenv</artifactId>
  <version>2.5.4</version>
</dependency>
```
To use Cucumber framework in JavaScript

```bash
npm init
npm install @cucumber/cucumber
```
To run all Cucumber tests
```bash
npx cucumber-js
```

To run all Cucumber tests with the specified tag

```javascript
//package.json

"test": "cucumber-js"
```

```bash
npm test -- --tags=@HealthCheck
```



