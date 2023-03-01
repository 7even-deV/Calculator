package com.bosonit;

import com.bosonit.calculator.application.CalculatorServiceImpl;
import com.bosonit.calculator.domain.CalculatorDomain;
import com.bosonit.calculator.infrastructure.repository.CalculatorRepository;

import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Tag("UnitTest")
@DisplayName("UnitTest - CalculatorServiceTest")
class CalculatorApplicationTests {

	private final CalculatorDomain calculatorTest = new CalculatorDomain(1L, "messageTest", new BigDecimal(40));
	private final List<CalculatorDomain> calculatorsTest = List.of(calculatorTest);

	@Mock
	CalculatorRepository calculatorRepository;

	@InjectMocks
	TracerImpl tracerAPI;

	@InjectMocks
	CalculatorServiceImpl calculatorService;

	@BeforeEach
	void setUp() {
		calculatorRepository.save(calculatorTest);
	}

	@Test
	@Order(1)
	@DisplayName("additionOperationTest")
	void additionOperationTest() {

		BigDecimal firstParameter = new BigDecimal(17);
		BigDecimal secondParameter = new BigDecimal(23);
		BigDecimal result = firstParameter.add(secondParameter);

		tracerAPI.trace(result);
		String message = "The result of adding "+firstParameter+ " and "+secondParameter+" is " + result;

		CalculatorDomain calculatorTest = new CalculatorDomain();
		calculatorTest.setMessage(message);
		calculatorTest.setResult(result);

		when(calculatorRepository.save(Mockito.any(CalculatorDomain.class))).thenReturn(calculatorTest);
		Assertions.assertEquals(calculatorTest, calculatorService.additionOperation(firstParameter, secondParameter));
	}

	@Test
	@Order(2)
	@DisplayName("subtractionOperationTest")
	void subtractionOperationTest() {

		BigDecimal firstParameter = new BigDecimal(17);
		BigDecimal secondParameter = new BigDecimal(23);
		BigDecimal result = firstParameter.subtract(secondParameter);

		tracerAPI.trace(result);
		String message = "The result of subtracting "+firstParameter+ " and "+secondParameter+" is " + result;

		CalculatorDomain calculatorTest = new CalculatorDomain();
		calculatorTest.setMessage(message);
		calculatorTest.setResult(result);

		when(calculatorRepository.save(Mockito.any(CalculatorDomain.class))).thenReturn(calculatorTest);
		Assertions.assertEquals(calculatorTest, calculatorService.subtractionOperation(firstParameter, secondParameter));
	}

	@Test
	@Order(3)
	@DisplayName("getAllResultsTest")
	void getAllResultsTest() {
		when(calculatorRepository.findAll()).thenReturn(calculatorsTest);
		Assertions.assertEquals(calculatorsTest, calculatorService.getResults());
	}

	@Test
	@Order(4)
	@DisplayName("getResultByIdTest")
	void getResultByIdTest() throws Exception {
		when(calculatorRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(calculatorTest));
		Assertions.assertEquals(calculatorTest, calculatorService.getResultId(1L));
	}
}
