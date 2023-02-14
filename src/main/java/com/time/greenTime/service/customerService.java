package com.time.greenTime.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.time.greenTime.entity.customerEntity;
import com.time.greenTime.repository.customerRepository;

@Service
public class customerService {

	@Autowired
	customerRepository _customerRepository;
	@Autowired
	@Qualifier("validatingCustomer")
	commonInterface _commonInterface;

	public Map<String, Object> executeCreateCustomer(List<customerEntity> customer) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		_customerRepository.saveAll(customer);
		result.put("Message", "Success");
		return result;

	}

	public Object executeListOfCustomer(String desc, Integer pageSkip, Integer pageFetch, Integer custId) {
		Pageable pagination = PageRequest.of(pageSkip, pageFetch, Sort.by("creationDate").descending());
		Page<customerEntity> customerDetail = _customerRepository.findAll(pagination);

		List<customerEntity> list = _commonInterface.checkActiveCustomer(customerDetail);

		List<Object> result = _commonInterface.getTheData(list, desc);

		return result;
	}
}
