package com.bosonit.calculator.infrastructure.repository;

import com.bosonit.calculator.domain.CalculatorDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorRepository extends JpaRepository<CalculatorDomain, Long> {
}
