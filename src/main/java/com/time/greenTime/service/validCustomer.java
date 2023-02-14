package com.time.greenTime.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.time.greenTime.entity.customerEntity;

@Component(value="validatingCustomer")
public class validCustomer  implements  commonInterface
{

	@Override
	public List<Object> getTheData(List<customerEntity> cust, String desc) {
		System.out.println("inside the commonimplementation");
		if (desc.equalsIgnoreCase("Address")) {
			return cust.stream().map(i -> i.getAddr()).collect(Collectors.toList());
		} else if (desc.equalsIgnoreCase("Pay")) {
			return cust.stream().map(i -> i.getPay()).collect(Collectors.toList());
		} else {
			return cust.stream().collect(Collectors.toList());
		}
	}

	

}
