package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    // Returns instance of class StaticFilterBeanOne where static filtering happens
    @GetMapping("/static-filtering-one")
    public StaticFilterBeanOne retrieveSomeBean() {
        return new StaticFilterBeanOne("value1", "value2", "value3");
    }

    // Returns instance of class StaticFilterBeanTwo where static filtering happens
    @GetMapping("/static-filtering-two")
    public List<StaticFilterBeanTwo> retrieveListOfSomeBean() {
        return Arrays.asList(
                new StaticFilterBeanTwo("value1", "value2", "value3"),
                new StaticFilterBeanTwo("value11", "value12", "value13")
        );
    }
}
