package com.time.greenTime.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class customerDetailUpdateDto {

	private Integer servicesCenter;
	private String customerType;
	private String address;
	private String pinCode;
	private String phoneNumber;
	private Integer addressId;
	private Integer payId;
	private String accountNumber;
	private String branch;
	private String paymentMethod;
	private String city;

}
