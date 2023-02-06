package com.time.greenTime.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.time.greenTime.dto.customerDto;
import com.time.greenTime.entity.customerEntity;
import com.time.greenTime.service.customerService;

@RestController
@RequestMapping("/c1")
public class customerController {
	@Autowired
	customerService _customerService;

	@GetMapping("/test/{id}")
	public ResponseEntity<Object> getResult(@PathVariable(value = "id") Integer id) {
		return new ResponseEntity<Object>("Welocme to springboot", HttpStatus.OK);
	}

	@PostMapping("/create/customer")
	@ResponseBody
	public ResponseEntity<Object> createCustomer(@RequestBody @Valid List<customerEntity> customer) throws Exception {
		Object result = _customerService.executeCreateCustomer(customer);
		return new ResponseEntity<Object>(result, HttpStatus.CREATED);
	}

	@GetMapping("/customer/list")
	@ResponseBody
	public ResponseEntity<Object> getListOfCustomer() {

		Object result = _customerService.executeListOfCustomer();
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

}
