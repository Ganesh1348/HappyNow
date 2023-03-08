package com.time.greenTime.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.time.greenTime.advice.globalExceptionHandler;
import com.time.greenTime.dto.customerDetailUpdateDto;
import com.time.greenTime.entity.customerEntity;
import com.time.greenTime.repository.customerRepository;

@Service
@Transactional
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

	public Object executeCustomerUpdate(Integer customerId, customerDetailUpdateDto detail) {
		Map<String, Object> result = new HashMap<String, Object>();
		customerEntity customerList = _customerRepository.findById(customerId)
				.orElseThrow(() -> new NoSuchElementException());
		Optional<String> s = Optional.ofNullable(customerList.getCustomerType());
		if (s.isPresent()) {
			if (customerList.getCustomerStatus().equalsIgnoreCase("ACTIVE")) {
				if (detail.getCustomerType() != null || detail.getServicesCenter() != null) {
					_customerRepository.updateCustomerQuery(detail.getCustomerType(), detail.getServicesCenter(),
							customerId);
				} else if (detail.getPayId() != null) {
					_customerRepository.updatePayDetail(detail.getAccountNumber(), detail.getBranch(),
							detail.getPaymentMethod(), detail.getPayId());
				} else if (detail.getAddressId() != null) {
					_customerRepository.updateAddressDetail(detail.getAddress(), detail.getCity(), detail.getPinCode(),
							detail.getPhoneNumber(), detail.getAddressId());
				}
			} else {
				result.put("Message", "Customer Number " + customerId + " is not active");
				return result;
			}
			result.put("Message", "Success");
		} else {
			result.put("Message",
					"Customer Number " + customerId + " is not updated, please check the customer detail");
		}
		return result;
	}

	public Object deleteCustDtl(Integer customerId) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<customerEntity> customerList=_customerRepository.findAll();
		Optional<customerEntity> s=customerList.stream().filter(i->i.getId()==customerId).findAny();
		System.out.println(s);
		return result;
	}
}
