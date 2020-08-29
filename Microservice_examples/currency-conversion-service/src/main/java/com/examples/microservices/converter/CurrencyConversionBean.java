package com.examples.microservices.converter;

import java.math.BigDecimal;

public class CurrencyConversionBean 
{
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCaluculatedAmount;
	private String port;
	
	public CurrencyConversionBean() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyConversionBean(Long id, String fromCurrency, String toCurrency, BigDecimal conversionMultiple,
			BigDecimal quantity, BigDecimal totalCaluculatedAmount, String port) 
	{
		super();
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCaluculatedAmount = totalCaluculatedAmount;
		this.port = port;
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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCaluculatedAmount() {
		return totalCaluculatedAmount;
	}

	public void setTotalCaluculatedAmount(BigDecimal totalCaluculatedAmount) {
		this.totalCaluculatedAmount = totalCaluculatedAmount;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CurrencyConversionBean [id=" + id + ", fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency
				+ ", conversionMultiple=" + conversionMultiple + ", quantity=" + quantity + ", totalCaluculatedAmount="
				+ totalCaluculatedAmount + ", port=" + port + "]";
	}

}
