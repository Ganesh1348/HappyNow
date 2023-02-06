package com.time.greenTime.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

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
@Table(name = "cust_pay_03")
public class customerPayEntity {
	@Id
	@Column(name = "cust_pay_id")
	@TableGenerator(name = "cust_pay", initialValue = 25000)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "cust_pay")
	private int id;
	@Column(name = "pay_cd", nullable = false)
	private String paymentMethod;
	@Column(name = "acc_num", length = 30)
	private String accountNumber;
	private String branch;
	@Column(nullable = false, columnDefinition = "Date default (CURRENT_DATE())", updatable = false, insertable = false)
	private Date creationDate;
	@Column(nullable = false, columnDefinition = "Date default (CURRENT_DATE())", insertable = false)
	private Date lastUpdatedDate;
}
