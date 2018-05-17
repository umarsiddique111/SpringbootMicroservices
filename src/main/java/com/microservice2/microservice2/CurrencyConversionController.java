package com.microservice2.microservice2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class CurrencyConversionController {
  
  @Autowired
  private Environment environment;
  
  @Autowired
  private ExchangeValueRepository repository;
  
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyConversionBean retrieveExchangeValue
    (@PathVariable String from, @PathVariable String to){
    
	  CurrencyConversionBean currencyConversionBean = 
        repository.findByFromAndTo(from, to);
    
	  currencyConversionBean.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));
    
    return currencyConversionBean;
  }
}