package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
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

    // Configures filtering and maps it with the instance of bean DynamicFilterBean to filter concrete attributes
    @GetMapping("/dynamic-filtering-one")
    public MappingJacksonValue retrieveDynamicFilterBean() {
        DynamicFilterBean dynamicFilterBean = new DynamicFilterBean("value1", "value2", "value3");

        // Setting up filters
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);

        // Mapping filters and classes
        MappingJacksonValue mapping = new MappingJacksonValue(dynamicFilterBean);
        mapping.setFilters(filters);

        return mapping;
    }

    // Configures a different filtering and maps it with the instance of bean DynamicFilterBean to filter concrete attributes
    @GetMapping("/dynamic-filtering-two")
    public MappingJacksonValue retrieveListOfDynamicFilterBean() {
        List<DynamicFilterBean> list = Arrays.asList(
                new DynamicFilterBean("value1", "value2", "value3"),
                new DynamicFilterBean("value11", "value12", "value13")
        );

        // Setting up filters
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);

        // Mapping filters and classes
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);

        return mapping;
    }
}
