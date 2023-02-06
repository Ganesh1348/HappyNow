package com.time.greenTime.dto;


import java.sql.Date;

import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@Data
public class customerAddrDto {

	@NotNull(message = "address may not be null")
	private String address;
	@NotNull(message = "city may not be null")
	private String city;
	@NotNull(message = "pincode may not be null")
	private String pinCode;
	// @Pattern(regexp="^[0-9]",message="Please Enter only number in the phone
	// number field")
	private String phoneNumber;
	private String addressType;
	private Date creationDate;
	private Date lastUpdatedDate;
	private int customerAddressId;

}
