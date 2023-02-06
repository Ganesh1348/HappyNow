package com.time.greenTime.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time.greenTime.entity.customerEntity;
import com.time.greenTime.repository.customerRepository;

@Service
public class customerService {

	@Autowired
	customerRepository _customerRepository;
	@Autowired
	commonImplementation _commonImplementation;

	public Map<String, Object> executeCreateCustomer(List<customerEntity> customer) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		_customerRepository.saveAll(customer);

		result.put("Message", "Success");
		return result;

	}

	public List<Object> executeListOfCustomer() {
		List<customerEntity> customerDetail = _customerRepository.findAll();
		List<Object> result = _commonImplementation.validResult(customerDetail);

		return result;
	}
}
