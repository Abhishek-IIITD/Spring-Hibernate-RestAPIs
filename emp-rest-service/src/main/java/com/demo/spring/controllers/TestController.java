package com.demo.spring.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {  //use postman to execute....
 //it should be stateless. so, no instance variables declarations here
	//http://host:port/greet/Scott
	/*@RequestMapping(path="/greet/{name}", method =RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String greet(@PathVariable("name") String userName) {
		return "Hello from Spring REST for "+userName;
	}*/

	@RequestMapping(path="/greet/{name}", method =RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> greet(@PathVariable("name") String userName) {
		return ResponseEntity.ok("Hello from Spring REST for "+userName);
		//return ResponseEntity.status(401).build();  //Unauthorised
	}

}
