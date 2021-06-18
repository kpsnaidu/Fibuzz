package com.codetest.service;

import com.codetest.util.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class FibuzzNumberService {


    public List<String> printNumbers(int uptoNumber){
        List<String> numbers = new ArrayList<>();

        IntStream.range(1,uptoNumber+1).forEach(i -> {
            boolean divisibleBy3 = NumberUtils.isDivisibleByN(i,3);
            boolean divisibleBy5 = NumberUtils.isDivisibleByN(i,5);;

            printAndAddToListIfConditionsMatches(numbers, i, divisibleBy3, divisibleBy5);
        });

        return numbers;
    }

    public List<String> printNumbersWithAdditionalConstraints(int uptoNumber) {

        List<String> numbers = new ArrayList<>();
        IntStream.range(1,uptoNumber+1).forEach(i -> {
            boolean divisibleBy3OrHasA3 = NumberUtils.isDivisibleByN(i,3) || NumberUtils.hasN(i,3);
            boolean divisibleBy5OrHasA5 = NumberUtils.isDivisibleByN(i,5) || NumberUtils.hasN(i,5);

            printAndAddToListIfConditionsMatches(numbers, i, divisibleBy3OrHasA3, divisibleBy5OrHasA5);
        });

        return numbers;
    }

    private void printAndAddToListIfConditionsMatches(List<String> numbers, int input, boolean matchedCondition1, boolean matchedCondition2) {

        if(matchedCondition1 && matchedCondition2){
            numbers.add("FizzBuzz");
            System.out.println("FizzBuzz");
        } else if (matchedCondition1){
            numbers.add("Fizz");
            System.out.println("Fizz");
        } else if (matchedCondition2){
            numbers.add("Buzz");
            System.out.println("Buzz");
        } else {
            numbers.add(String.valueOf(input));
            System.out.println(input);
        }
    }

}
