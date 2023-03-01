package com.bosonit.calculator.infrastructure.controller;

import com.bosonit.calculator.application.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/add")
    public ResponseEntity<String> getAddition(
            @RequestParam(name="first", required = true) BigDecimal firstParameter,
            @RequestParam(name="second", required = true) BigDecimal secondParameter){

        var message = calculatorService.additionOperation(firstParameter, secondParameter).getMessage();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/subtract")
    public ResponseEntity<String> getSubtraction(
            @RequestParam(name="first", required = true) BigDecimal firstParameter,
            @RequestParam(name="second", required = true) BigDecimal secondParameter){

        var message = calculatorService.subtractionOperation(firstParameter, secondParameter).getMessage();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
