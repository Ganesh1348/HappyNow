package com.time.greenTime.service;

import java.util.List;

import com.time.greenTime.entity.customerEntity;

@FunctionalInterface
public interface commonInterface {

	List<Object> validResult(List<customerEntity> result);
}
