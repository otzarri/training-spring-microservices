package com.in28minutes.microservices.currencyconversionservice;

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
public class CurrencyConversionController {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private CurrencyExchangeServiceProxy proxy;
    
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(
        @PathVariable String from,
        @PathVariable String to,
        @PathVariable BigDecimal quantity) {
        
        String url = "http://localhost:8000/currency-exchange/from/{from}/to/{to}/"; 
        Class<CurrencyConversionBean> responseType = CurrencyConversionBean.class;
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        
        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(url, responseType, uriVariables);
        CurrencyConversionBean response = responseEntity.getBody();
        
        logger.info("{}", response);
        
        return new CurrencyConversionBean(
                response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort()
            );
    }
    
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(
        @PathVariable("from") String from,
        @PathVariable("to") String to,
        @PathVariable("quantity") BigDecimal quantity) {
        
        CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
        
        logger.info("{}", response);
        
        return new CurrencyConversionBean(
                response.getId(),
                from,
                to,
                response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort()
            );
    }
}
