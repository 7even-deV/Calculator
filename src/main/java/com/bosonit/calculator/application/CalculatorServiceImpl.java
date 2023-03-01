package com.bosonit.calculator.application;

import com.bosonit.calculator.domain.CalculatorDomain;
import com.bosonit.calculator.infrastructure.repository.CalculatorRepository;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements ICalculatorService{

    CalculatorRepository repository;

    TracerImpl tracerAPI;

    public CalculatorServiceImpl (CalculatorRepository cRepository){
        this.repository = cRepository;
        tracerAPI = new TracerImpl();
    }
    @Override
    public CalculatorDomain additionOperation(BigDecimal firstParameter, BigDecimal secondParameter){

        BigDecimal result = firstParameter.add(secondParameter);
        tracerAPI.trace(result);
        String message = "The result of adding "+firstParameter+ " and "+secondParameter+" is " + result;

	    CalculatorDomain calculator = new CalculatorDomain();
        calculator.setMessage(message);
        calculator.setResult(result);

        return repository.save(calculator);
    }

    @Override
    public CalculatorDomain subtractionOperation(BigDecimal firstParameter, BigDecimal secondParameter){

        BigDecimal result = firstParameter.subtract(secondParameter);
        tracerAPI.trace(result);
        String message = "The result of subtracting "+firstParameter+ " and "+secondParameter+" is " + result;

	    CalculatorDomain calculator = new CalculatorDomain();
        calculator.setMessage(message);
        calculator.setResult(result);

        return repository.save(calculator);
    }
}
