package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Seting this class as REST controller
@RestController
public class HelloWorldController {

    // Mapping GET request path with the method below (Way 1: @RequestMapping)
    @RequestMapping(method = RequestMethod.GET, path = "hello-world")
    public String HelloWorld() {
        return "Hello World!";
    }

    // Mapping GET request path with the method below (Way 2: Using @GetMapping)
    @GetMapping(path = "hello-java")
    public String HelloJava() {
        return "Hello Java!";
    }

    // Mapping GET request path with the method below (Way 3: Using shorter @GetMapping)
    @GetMapping("hello-spring")
    public String HelloSpring() {
        return "Hello Spring!";
    }
}
