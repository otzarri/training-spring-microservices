package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

// Seting this class as REST controller
@RestController
public class HelloWorldController {

    // Object to print messages in the corresponding language
    @Autowired
    private MessageSource messageSource;

    // Mapping GET request path with the method below
    @GetMapping("/hello-world")
    public String HelloWorld() {
        return "Hello World!";
    }

    // Mapping GET request path with the bean below
    @GetMapping("/hello-world-bean")
    public HelloWorldBean HelloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    // Mapping GET request path with the bean below passing values from Path Variable
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean hellowWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    // Internationalization in an endpoint
    @GetMapping("/hello-world-internationalized")
    public String HelloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
