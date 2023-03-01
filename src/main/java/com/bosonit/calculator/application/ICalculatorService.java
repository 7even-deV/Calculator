package com.bosonit.calculator.application;

import com.bosonit.calculator.domain.CalculatorDomain;

import java.math.BigDecimal;
import java.util.List;

public interface ICalculatorService {

	CalculatorDomain additionOperation(BigDecimal firstParameter, BigDecimal secondParameter);
	CalculatorDomain subtractionOperation(BigDecimal firstParameter, BigDecimal secondParameter);

	List<CalculatorDomain> getResults();
	CalculatorDomain getResultId(Long id);
	void deleteResult(Long id);
}
