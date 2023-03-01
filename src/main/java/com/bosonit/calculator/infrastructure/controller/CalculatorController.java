package com.bosonit.calculator.infrastructure.controller;

import com.bosonit.calculator.application.ICalculatorService;
import com.bosonit.calculator.domain.CalculatorDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @Autowired
    private ICalculatorService calculatorService;

    // ResponseEntity

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

    // Objects

    @GetMapping("/all")
    public List<CalculatorDomain> getResults() {
        return calculatorService.getResults();
    }

    @GetMapping("/id/{id}")
    public CalculatorDomain getResultId(@PathVariable("id") Long id) {
        return calculatorService.getResultId(id);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteResult(@PathVariable("id") Long id) {
        calculatorService.deleteResult(id);
    }
}
