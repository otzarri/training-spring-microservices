package com.in28minutes.microservices.springbootin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
		    System.out.println(name);
		}
	}
}
