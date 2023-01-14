package com.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	  
	/*
	 * @RequestMapping(value="/getxmlperson", method=RequestMethod.GET,
	 * produces=MediaType.APPLICATION_XML_VALUE )
	 * 
	 * @GetMapping is shorthand of @RequestMapping(method=RequestMathod.GET)
	 */
	  
	  
	 

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String HelloController() {
		System.out.println("u can do this");
		return "hello world!!";
	}

}
