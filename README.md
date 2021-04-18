# API Test Framework Example
This is an example of an API Test Framework that is written in Java.

1. [System Under Test](#sut)
2. [Requirements](#requirements)
2. [Repository structure](#structure)
3. [Libraries and Frameworks](#swagger)
5. [Run tests](#run-tests)

## System Under Test <a name="sut"></a>
The [REST version of Spring PetClinic Sample Application](https://github.com/spring-petclinic/spring-petclinic-rest) is used as SUT.

## Requirements <a name="requirements"></a>
To be able to execute the API tests on your locale machine you need:
* Java >= 1.8
* Docker

## Repository structure <a name="structure"></a>
TBD

## Libraries and Frameworks <a name="overview"></a>
* [Guice](https://github.com/google/guice) - to implement Dependency Injection pattern.
* [Owner](http://owner.aeonbits.org/) - to get rid of the boilerplate code in properties based configuration.
* [REST-assured](https://rest-assured.io/) - to simplify testing of REST based services.
* [Allure](https://docs.qameta.io/allure/) - to provide test reports.
* [Testcontainers](https://www.testcontainers.org/) - to provide dockerised test environment configuration.
* [JUnit 5](https://junit.org/junit5/docs/current/user-guide/) - to execute tests.

## Run tests <a name="run-tests"></a>
### with dockerised environment
The test execution with `DOCKERISED` test environment considers that the test environment is provided as a docker image.
So what you need is just to put some necessary SUT related properties int to `petclinic-dockerised.properties` file and run the command [1].
* [1] `mvn clean test allure:serve -Denv=DOCKERISED`

What will happen under the hood after the command [1] is executed:
* The docker container for [REST version of Spring PetClinic Sample Application](https://github.com/spring-petclinic/spring-petclinic-rest) will be pulled and started automatically before test execution.
* The properties for test execution will be taken from `petclinic-dockerised.properties` file.
* The tests will be executed.
* The docker container for [REST version of Spring PetClinic Sample Application](https://github.com/spring-petclinic/spring-petclinic-rest) will be stopped automatically after test execution.
* The test report will be generated and showed by the automatically started Allure server.


### with test environment
The test execution with `TEST` environment considers that the there is an instance of test environment that is managed by someone. 
So you need to put all connection related properties int to `petclinic-test.properties` file and run the command [2].

In this particular example we use [REST version of Spring PetClinic Sample Application](https://github.com/spring-petclinic/spring-petclinic-rest) docker image to start test environment by running the command [1]. 
* [1] `docker run -p 9966:9966 springcommunity/spring-petclinic-rest:2.1.5`
* [2] `mvn clean test allure:serve -Denv=TEST`

What will happen under the hood after the command [1] is executed:
* The docker container for [REST version of Spring PetClinic Sample Application](https://github.com/spring-petclinic/spring-petclinic-rest) will be pulled and started.

What will happen under the hood after the command [2] is executed:
* The properties for test execution will be taken from `petclinic-test.properties` file. 
* The tests will be executed.
* The test report will be generated and showed by the automatically started Allure server.

### with live environment
The test execution with `LIVE` environment considers that the tests will be executed against production environment.
So you need to put all connection related properties int to `petclinic-live.properties` file and run the command [1].
* [1] `mvn clean test allure:serve -Denv=LIVE`

What will happen under the hood after the command [1] is executed:
* The properties for test execution will be taken from `petclinic-live.properties` file.
* The tests will be executed.
* The test report will be generated and showed by the automatically started Allure server.

