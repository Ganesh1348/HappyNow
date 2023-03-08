package com.time.greenTime.service;

import java.util.List;
import java.util.stream.Collectors;

import com.time.greenTime.entity.customerEntity;

public class customerDetailUpdate implements commonInterface
{

	@Override
	public List<Object> getTheData(List<customerEntity> cust, String desc) {
		if (desc.equalsIgnoreCase("Address")) {
			return cust.stream().map(i -> i.getAddr()).collect(Collectors.toList());
		} else if (desc.equalsIgnoreCase("Pay")) {
			return cust.stream().map(i -> i.getPay()).collect(Collectors.toList());
		} else {
			return cust.stream().collect(Collectors.toList());
		}
	}

}
