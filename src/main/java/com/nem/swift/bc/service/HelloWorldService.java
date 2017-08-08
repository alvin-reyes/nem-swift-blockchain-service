package com.nem.swift.bc.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldService {
	
    @RequestMapping(method=RequestMethod.GET,path="/")
    public String ahoy() {
    	
        return "AHOY!";
    }
    
    @RequestMapping(method=RequestMethod.GET,path="/helloworld")
    public String index() {
    	
        return "Greetings from Spring Boot!";
    }
}

