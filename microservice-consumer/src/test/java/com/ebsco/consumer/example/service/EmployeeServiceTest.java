package com.ebsco.consumer.example.service;

import com.ebsco.consumer.example.MicroServiceApplication;
import com.ebsco.consumer.example.model.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by aganapathy on 12/12/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicroServiceApplication.class)
@AutoConfigureStubRunner(ids = "com.ebsco.producer.example:microservice-producer:+:stubs:8082", workOffline = true)
public class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testGetEmployeeDetails() throws Exception {

        //Given
        Response response = employeeService.getEmployeeDetails();

        // then:
        String message = response.getMessage();

        // and:
        assert(message.contains("ARUN"));
    }



}
