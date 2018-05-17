package com.microservice2.microservice2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends 
    JpaRepository<CurrencyConversionBean, Long>{
	CurrencyConversionBean findByFromAndTo(String from, String to);
}