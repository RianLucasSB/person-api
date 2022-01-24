package com.one.digital.innovation.personapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/people")
public class PersonController {

    @GetMapping
    public String getPeople(){
        return "API test";
    }
}
