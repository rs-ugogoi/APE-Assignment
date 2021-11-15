package com.EmployeeDataManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeDataPojo, Integer> {

	
	
}
