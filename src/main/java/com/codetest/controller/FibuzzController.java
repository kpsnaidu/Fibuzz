package com.codetest.controller;

import com.codetest.service.FibuzzNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/maths")
public class FibuzzController {

    @Autowired
    FibuzzNumberService service;

    @GetMapping(value = "/print/upto/{number}/v1")
    public List<String> printNumbersUptoGivenNumberV1(@PathVariable("number") int number){

        return service.printNumbers(number);
    }

    @GetMapping(value = "/print/upto/{number}/v2")
    public List<String> printNumbersUptoGivenNumberV2(@PathVariable("number") int number){

        return service.printNumbersWithAdditionalConstraints(number);
    }
}
