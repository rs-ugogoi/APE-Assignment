package com.EmployeeDataManagement.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeDataPojo, Integer> {

	@Modifying()
	@Query(value="UPDATE EmployeeDataPojo set password=:password where emp_id=:empId")
	@Transactional
	void setPassword(@Param("password") String password, @Param("empId") String empId);
	
//	@Query("from EmployeeDataPojo where email=?1 and password=?2") 
//	EmployeeDataPojo login(String email,String password);
	
	@Query("from EmployeeDataPojo where email=?1") 
	EmployeeDataPojo findEmp(String email);
}
