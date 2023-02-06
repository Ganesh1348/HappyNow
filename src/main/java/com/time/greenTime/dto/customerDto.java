package com.time.greenTime.dto;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class customerDto {

	private int id;
	private String customerName;
	private String customerType;
	private int servicesCenter;
	private String customerStatus;
	private Date creationDate;
	private Date lastUpdatedDate;
	private Date lastActiveDate;
	private List<customerAddrDto> addr;
	private Set<customerPayDto> pay;
}
