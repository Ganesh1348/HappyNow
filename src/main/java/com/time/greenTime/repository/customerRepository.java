package com.time.greenTime.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.time.greenTime.entity.customerEntity;

@Repository
public interface customerRepository extends JpaRepository<customerEntity, Integer> {

	String payUpdateQuery = "update customerPayEntity set accountNumber=?1,branch=?2,paymentMethod=?3 where id=?4";
	String addressUpdateQuery = "update customerAddressEntity set address=?1,city=?2,pinCode=?3,phoneNumber=?4 where id=?5";
	String customerUpdateQuery = "update customerEntity set customerType=?1,servicesCenter=?2 where id=?3";

	@Modifying
	@Query(payUpdateQuery)
	public void updatePayDetail(String accountNumber, String branch, String paymentMethod, int id);

	@Modifying
	@Query(addressUpdateQuery)
	public void updateAddressDetail(String address, String city, String pinCode, String phoneNumber, int id);

	@Modifying
	@Query(customerUpdateQuery)
	public void updateCustomerQuery(String customerType, Integer servicesCenter, Integer customerId);

}
