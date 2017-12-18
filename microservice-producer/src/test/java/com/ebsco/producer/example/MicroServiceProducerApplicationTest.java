package com.ebsco.producer.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * Created by aganapathy on 12/12/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MicroServiceProducerApplicationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testApplicationHealth() throws  Exception{
        Map<String, String> response = restTemplate.getForObject("/health", Map.class);
        System.out.println(response.toString());
        Assert.assertEquals("UP",response.get("status"));

    }

}