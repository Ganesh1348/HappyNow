package com.time.greenTime.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.time.greenTime.entity.customerEntity;

@Component(value="commonImpl")
public class commonImplementation implements commonInterface {

	@Override
	public List<Object> getTheData(List<customerEntity> cust, String desc) {
		System.out.println("inside the commonimplementation");
		if (desc.equalsIgnoreCase("Address")) {
			return null;
		} else if (desc.equalsIgnoreCase("Pay")) {
			return null;
		} else {
			return null;
		}
	}
}
