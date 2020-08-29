package com.examples.microservices.exchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController 
{
	Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable(value = "from") String fromCurrency, 
			@PathVariable(value = "to") String toCurrency) 
	{
		logger.info("Entering CurrencyExchangeController::retrieveExchangeValue()-->"
				+ "fromCurrency:"+fromCurrency
				+ "toCurrency:"+toCurrency);
		
		//ExchangeValue exchangeValue = new ExchangeValue(1L, "INR", "USD", BigDecimal.valueOf(65));
		
		ExchangeValue exchangeValue = repository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		exchangeValue.setPort(environment.getProperty("local.server.port"));
		logger.info("exchangeValue: "+exchangeValue);
		
		return exchangeValue;
	}
}
