package com.ebsco.example;

import com.ebsco.example.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.springframework.boot.test.json.JacksonTester;

public abstract class AbstractTest {

    public JacksonTester<Employee> json;
    

    @Before
    public void setup() {
        ObjectMapper objectMappper = new ObjectMapper();
        JacksonTester.initFields(this, objectMappper);
    }
}
