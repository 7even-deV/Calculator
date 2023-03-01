package com.bosonit.calculator.application;

import com.bosonit.calculator.domain.CalculatorDomain;

import java.math.BigDecimal;

public interface ICalculatorService {

	CalculatorDomain additionOperation(BigDecimal firstParameter, BigDecimal secondParameter);
	CalculatorDomain subtractionOperation(BigDecimal firstParameter, BigDecimal secondParameter);
}
