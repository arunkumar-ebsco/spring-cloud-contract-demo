# spring-cloud-contract-demo
Sample implementation of spring-cloud-contract

# What you need

 Java
 Spring Boot (1.4.1.RELEASE)
 Spring Cloud Contract (1.0.1.RELEASE)
 Gradle (3.1)
 Local Maven Repo
 Artifactory (in case you publish the stubs to remote location)

# Step by Step Workflow

1. Add a test: On the consumer side, we start by writing the functional test for the new feature, and implementing the gateway that communicates with the producer endpoint.
   (microservice-consumer/src/test/main/.../EmployeeConsumerServiceTest.java)
   
2. Run all tests: Obviously they fail

3. Add required contracts in (microservice-producer/src/test/resources/contracts)

4. In microservice-producer, run gradle generateContractTests to generate the test in the build folder

5. In microservice-producer, implement the ContractVerifierBase class to load web context and set up RestAssuredMockMvc

6. We also need the following settings in the build.gradle file to tell the spring-cloud-contractplugin to locate the ContractVerifierBase class

7. In microservice-producer, implement the producer’s new endpoint to pass the test. (Refer EmployeeController.java)

8. Ensure gradle clean build passes the contract verifier tests

9. Execute gradle clean install to push the stubs to local maven repo (.m2/repository/com/ebsco/producer/microservice-producer.../stubs.jar)

10. Finally, on the consumer side, simply add
    @AutoConfigureStubRunner(ids = "com.ebsco.producer.example:microservice-producer:+:stubs:8082", workOffline = true)
    
    This stub runner will pull and unpackage the latest stubs jar file (as we set the version to a “+” symbol), start up a WireMock server on port 8082 and register the stub mapping.
    
    Now we have the producer stub running, the test should pass.