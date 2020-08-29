package com.examples.microservices.limits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.microservices.utils.Configuration;

@RestController
public class LimitsConfigController 
{
	@Autowired
	private Configuration limitsConfig;
	
	@GetMapping(path = "/limits")
	public LimitsConfiguration retrieveLimitsFromConfigurations() 
	{
		return new LimitsConfiguration(limitsConfig.getMaximum(),limitsConfig.getMinimum());
	}
}
