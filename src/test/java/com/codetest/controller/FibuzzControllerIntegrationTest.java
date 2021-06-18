package com.codetest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FibuzzControllerIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldInvokeFibuzzVersion1ApiSuccessfully() {

        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("/maths/print/upto/15/v1", String[].class);
        String[] body = responseEntity.getBody();

        assertEquals(15, body.length);
        assertEquals(4, Arrays.stream(body).filter(s -> s.equals("Fizz")).count());
        assertEquals(2, Arrays.stream(body).filter(s -> s.equals("Buzz")).count());
        assertEquals(1, Arrays.stream(body).filter(s -> s.equals("FizzBuzz")).count());
    }

    @Test
    void shouldInvokeFibuzzVersion1ApiAndReturnCorrectListOfNumbers() {

        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("/maths/print/upto/100/v1", String[].class);
        String[] body = responseEntity.getBody();

        String[] expectedNumberList = new String[] {"1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz","16","17","Fizz","19","Buzz",
                "Fizz","22","23","Fizz","Buzz","26","Fizz","28","29","FizzBuzz","31","32","Fizz","34","Buzz","Fizz","37","38","Fizz","Buzz","41","Fizz","43","44",
                "FizzBuzz","46","47","Fizz","49","Buzz","Fizz","52","53","Fizz","Buzz","56","Fizz","58","59","FizzBuzz","61","62","Fizz","64","Buzz","Fizz","67","68",
                "Fizz","Buzz","71","Fizz","73","74","FizzBuzz", "76","77","Fizz","79","Buzz","Fizz","82","83","Fizz","Buzz","86","Fizz","88","89","FizzBuzz",
                "91","92","Fizz","94","Buzz","Fizz","97","98","Fizz","Buzz"};

        assertEquals(100, body.length);
        assertTrue(Arrays.equals(body, expectedNumberList));
    }

    @Test
    void shouldInvokeFibuzzVersion1ApiAndReturnEmptyListIfGivenNumberLessThan1() {

        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("/maths/print/upto/0/v1", String[].class);
        String[] body = responseEntity.getBody();

        assertEquals(0, body.length);
    }

    @Test
    void shouldInvokeFibuzzVersion2ApiSuccessfully() {

        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("/maths/print/upto/15/v2", String[].class);
        String[] body = responseEntity.getBody();

        assertEquals(15, body.length);
        assertEquals(5, Arrays.stream(body).filter(s -> s.equals("Fizz")).count());
        assertEquals(2, Arrays.stream(body).filter(s -> s.equals("Buzz")).count());
        assertEquals(1, Arrays.stream(body).filter(s -> s.equals("FizzBuzz")).count());
    }

    @Test
    void shouldInvokeFibuzzVersion2ApiAndReturnCorrectListOfNumbers() {

        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("/maths/print/upto/100/v2", String[].class);
        String[] body = responseEntity.getBody();

        String[] expectedNumberList = new String[] {"1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","Fizz","14","FizzBuzz","16","17","Fizz",
                "19","Buzz","Fizz","22","Fizz","Fizz","Buzz","26","Fizz","28","29","FizzBuzz","Fizz","Fizz","Fizz","Fizz","FizzBuzz","Fizz","Fizz","Fizz","Fizz",
                "Buzz","41","Fizz","Fizz","44","FizzBuzz","46","47","Fizz","49","Buzz","FizzBuzz","Buzz","FizzBuzz","FizzBuzz","Buzz","Buzz","FizzBuzz","Buzz",
                "Buzz","FizzBuzz","61","62","Fizz","64","Buzz","Fizz","67","68","Fizz","Buzz","71","Fizz","Fizz","74","FizzBuzz","76","77","Fizz","79","Buzz","Fizz",
                "82","Fizz","Fizz","Buzz","86","Fizz","88","89","FizzBuzz","91","92","Fizz","94","Buzz","Fizz","97","98","Fizz","Buzz"};

        assertEquals(100, body.length);
        assertTrue(Arrays.equals(body, expectedNumberList));
    }

    @Test
    void shouldInvokeFibuzzVersion2ApiAndReturnEmptyListIfGivenNumberLessThan1() {

        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("/maths/print/upto/-3/v1", String[].class);
        String[] body = responseEntity.getBody();

        assertEquals(0, body.length);
    }
}