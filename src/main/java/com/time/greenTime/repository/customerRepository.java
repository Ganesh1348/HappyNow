package com.time.greenTime.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.time.greenTime.entity.customerEntity;

@Repository
public interface customerRepository extends JpaRepository<customerEntity, Long> {
	

}
