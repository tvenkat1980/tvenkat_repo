package com.examples.microservices.exchange;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue 
{
	@Id
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal conversionMultiple;
	private String port;
	
	public ExchangeValue() {
		super();
	}

	public ExchangeValue(Long id, String fromCurrency, String toCurrency, BigDecimal conversionMultiple) 
	{
		super();
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionMultiple = conversionMultiple;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency
				+ ", conversionMultiple=" + conversionMultiple + ", port=" + port + "]";
	}
	
}
