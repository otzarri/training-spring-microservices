package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Seting this class as REST controller
@RestController
public class HelloWorldController {

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
}
