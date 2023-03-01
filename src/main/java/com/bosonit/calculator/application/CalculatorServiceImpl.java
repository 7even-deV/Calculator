package com.bosonit.calculator.application;

import com.bosonit.calculator.domain.CalculatorDomain;
import com.bosonit.calculator.infrastructure.repository.CalculatorRepository;
import com.bosonit.exception.NotFoundException;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    @Override
    public List<CalculatorDomain> getResults() {
        return repository.findAll();
    }

    @Override
    public CalculatorDomain getResultId(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No result found with id: " + id));
    }

    @Override
    public void deleteResult(Long id) {
        CalculatorDomain calculator = repository.findById(id).orElseThrow(() -> new NotFoundException("No result found with id: " + id));
        repository.delete(calculator);
    }
}
