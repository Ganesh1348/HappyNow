package com.time.greenTime.service;

import java.util.List;
import java.util.stream.Collectors;

import com.time.greenTime.entity.customerEntity;

public class commonImplementation implements commonInterface
{

	@Override
	public List<Object> validResult(List<customerEntity> result) {
		return result.stream().filter(i->i.getCustomerStatus().equalsIgnoreCase("ACTIVE")).collect(Collectors.toList());
	}

}
