package com.time.greenTime.dto;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@Data
public class customerPayDto {

	private String paymentMethod;
	private String accountNumber;
	private String branch;
	private Date creationDate;
	private Date lastUpdatedDate;
	private int id;
}
