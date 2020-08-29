package com.examples.microservices.converter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController 
{
	Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
   
	@GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable(value = "from") String fromCurrency,
			@PathVariable(value = "to") String toCurrency,
			@PathVariable BigDecimal quantity) 
	{
		//return new CurrencyConversionBean(1l,fromCurrency,toCurrency,BigDecimal.ONE,quantity,quantity,"0");
		
		//invoking currency exchange service
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", "INR");
		uriVariables.put("to", "USD");
		
		ResponseEntity<CurrencyConversionBean> responseEntity = 
				new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean response = responseEntity.getBody();
		logger.info("CurrencyConversionBean: "+response);
		
		return new CurrencyConversionBean(response.getId(),fromCurrency,toCurrency,
				response.getConversionMultiple(),
				quantity,quantity.multiply(response.getConversionMultiple()),
				response.getPort());
	}
	
	@GetMapping(path = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable(value = "from") String fromCurrency,
			@PathVariable(value = "to") String toCurrency,
			@PathVariable BigDecimal quantity) 
	{
		
		//invoking currency exchange service via open feign
		CurrencyConversionBean response = proxy.retrieveExchangeValue(fromCurrency, toCurrency);
		logger.info("CurrencyConversionBean: "+response);
		
		return new CurrencyConversionBean(response.getId(),fromCurrency,toCurrency,
				response.getConversionMultiple(),
				quantity,quantity.multiply(response.getConversionMultiple()),
				response.getPort());
	}
}
