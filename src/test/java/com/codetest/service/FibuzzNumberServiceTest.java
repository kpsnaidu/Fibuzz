package com.codetest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class FibuzzNumberServiceTest {

    private FibuzzNumberService fibuzzNumberService;

    @BeforeEach
    void setUp() {
        fibuzzNumberService = new FibuzzNumberService();
    }

    @Test
    void shouldPrintFizzForMultiplesOf3() {

        List<String> result = fibuzzNumberService.printNumbers(4);

        Assertions.assertEquals(4, result.size());
        Assertions.assertTrue(result.contains("1"));
        Assertions.assertTrue(result.contains("2"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("4"));

    }

    @Test
    void shouldPrintFizzForMultiplesOf3AndBuzzForMultiplesOf5AndFizzBuzzIfMultipliesByBoth3And5() {

        List<String> result = fibuzzNumberService.printNumbers(16);

        Assertions.assertEquals(16, result.size());
        Assertions.assertTrue(result.contains("1"));
        Assertions.assertTrue(result.contains("2"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("4"));
        Assertions.assertTrue(result.contains("Buzz"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("4"));
        Assertions.assertTrue(result.contains("4"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("Buzz"));
        Assertions.assertTrue(result.contains("4"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("13"));
        Assertions.assertTrue(result.contains("14"));
        Assertions.assertTrue(result.contains("FizzBuzz"));
        Assertions.assertTrue(result.contains("16"));

    }

    @Test
    void shouldReturnEmptyListIfGivenNumberLessThan1() {
        List<String> result = fibuzzNumberService.printNumbers(0);
        Assertions.assertTrue(result.isEmpty());

        result = fibuzzNumberService.printNumbers(-2);
        Assertions.assertTrue(result.isEmpty());

        result = fibuzzNumberService.printNumbers(-12);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void shouldPrintFizzForMultiplesOf3OrHas3AndBuzzForMultiplesOf5OrHas5AndFizzBuzzIfBothChecksMatches() {

        List<String> result = fibuzzNumberService.printNumbersWithAdditionalConstraints(4);

        Assertions.assertEquals(4, result.size());
        Assertions.assertTrue(result.contains("1"));
        Assertions.assertTrue(result.contains("2"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("4"));

        result = fibuzzNumberService.printNumbersWithAdditionalConstraints(35);

        Assertions.assertEquals(35, result.size());
        Assertions.assertTrue(result.contains("1"));
        Assertions.assertTrue(result.contains("2"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("4"));
        Assertions.assertTrue(result.contains("Buzz"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("7"));
        Assertions.assertTrue(result.contains("8"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("Buzz"));
        Assertions.assertTrue(result.contains("11"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("14"));
        Assertions.assertTrue(result.contains("FizzBuzz"));
        Assertions.assertTrue(result.contains("16"));
        Assertions.assertTrue(result.contains("17"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("19"));
        Assertions.assertTrue(result.contains("Buzz"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("22"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("Buzz"));
        Assertions.assertTrue(result.contains("26"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("28"));
        Assertions.assertTrue(result.contains("29"));
        Assertions.assertTrue(result.contains("FizzBuzz"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("Fizz"));
        Assertions.assertTrue(result.contains("FizzBuzz"));

    }

    @Test
    void shouldReturnEmptyListIfGivenNumberLessThan1WhilePrintingNumbersWithAdditonalConstraints() {
        List<String> result = fibuzzNumberService.printNumbersWithAdditionalConstraints(0);
        Assertions.assertTrue(result.isEmpty());

        result = fibuzzNumberService.printNumbers(-1);
        Assertions.assertTrue(result.isEmpty());

        result = fibuzzNumberService.printNumbers(-13);
        Assertions.assertTrue(result.isEmpty());
    }
}