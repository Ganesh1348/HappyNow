package com.time.greenTime.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cust_addr_02")
public class customerAddressEntity {

	@Id
	@TableGenerator(name = "cust_addr", initialValue = 15000)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "cust_addr")
	@Column(name = "cust_addr_id")
	private int customerAddressId;
	@Column(name = "addr", nullable = false)
	@NotNull(message = "address may not be null")
	private String address;
	@Column(nullable = false)
	@NotNull(message = "city may not be null")
	private String city;
	@Column(nullable = false)
	@NotNull(message = "pincode may not be null")
	private String pinCode;
	//@Pattern(regexp="^[0-9]",message="Please Enter only number in the phone number field")  
	private String phoneNumber;
	@Column(nullable = false, columnDefinition = "varchar(30) default 'home'", insertable = false)
	private String addressType;
	@Column(nullable = false, columnDefinition = "Date default (CURRENT_DATE())", updatable = false, insertable = false)
	private Date creationDate;
	@Column(nullable = false, columnDefinition = "Date default (CURRENT_DATE())", insertable = false)
	private Date lastUpdatedDate;

}
