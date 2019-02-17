package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
    // URL versioning: Expose method v1.
    @GetMapping("/v1/person-url")
    public PersonV1 urlVersioningPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    // URL versioning: Expose method v2.
    @GetMapping("/v2/person-url")
    public PersonV2 urlVersioningPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Param versioning: Expose method v1.
    @GetMapping(value = "/person-param", params = "version=1")
    public PersonV1 paramVersioningPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    // Param versioning: Expose method v2.
    @GetMapping(value = "/person-param", params = "version=2")
    public PersonV2 paramVersioningPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Header versioning: Expose method v1.
    @GetMapping(value = "/person-header", headers = "X-API-VERSION=1")
    public PersonV1 headerVersioningPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    // Header versioning: Expose method v2.
    @GetMapping(value = "/person-header", headers = "X-API-VERSION=2")
    public PersonV2 headerVersioningPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Produces versioning: Expose method v1. (Is a kind of header versioning)
    @GetMapping(value = "/person-produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesVersioningPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    // Produces versioning: Expose method v2. (Is a kind of header versioning)
    @GetMapping(value = "/person-produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesVersioningPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
