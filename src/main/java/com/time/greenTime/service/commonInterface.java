package com.time.greenTime.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.time.greenTime.entity.customerEntity;


public interface commonInterface {

	default public List<customerEntity> checkActiveCustomer(Page<customerEntity> customerDetail) {
		return customerDetail.stream().filter(i -> i.getCustomerStatus().equalsIgnoreCase("Active") && i.getServicesCenter()>0)
				.collect(Collectors.toList());
	}
	
	public  List<Object> getTheData(List<customerEntity> cust,String desc);
}
