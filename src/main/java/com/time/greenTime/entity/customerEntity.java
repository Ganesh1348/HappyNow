package com.time.greenTime.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cust_mstr_01")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class customerEntity {

	@TableGenerator(name = "cust_mstr", initialValue = 3000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "cust_mstr")
	@Column(name = "cust_id")
	private int id;
	@Column(name = "cust_nm", nullable = false)
	@NotNull(message = "customerName can not be null")
	private String customerName;
	@Column(name = "ser_cen_id")
	private Integer servicesCenter;
	@Column(name = "cust_typ_cd")
	private String customerType;
	@Column(name = "stat_cd", nullable = false, columnDefinition = "varchar(30) default 'ACTIVE'", insertable = false)
	private String customerStatus;
	@Column(nullable = false, columnDefinition = "Date default (CURRENT_DATE())", updatable = false, insertable = false)
	private Date creationDate;
	@Column(nullable = false, columnDefinition = "Date default (CURRENT_DATE())", insertable = false)
	private Date lastUpdatedDate;
	@CreationTimestamp
	private Date lastActiveDate;
	@OneToMany(targetEntity = customerAddressEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "f_cust_id", referencedColumnName = "cust_id")
	private List<customerAddressEntity> addr;
	@OneToMany(targetEntity = customerPayEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "f_cust_id", referencedColumnName = "cust_id")
	private Set<customerPayEntity> pay;

}
