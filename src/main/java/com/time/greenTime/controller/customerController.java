package com.time.greenTime.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c1")
public class customerController {

	
	@GetMapping("/test/{id}")
	public ResponseEntity<Object> getResult(@PathVariable(value="id") Integer id)
	{
		int h=5;
		System.out.println(h/0);
		return new ResponseEntity<Object>("Welocme to springboot",HttpStatus.OK);
	}
	
}
