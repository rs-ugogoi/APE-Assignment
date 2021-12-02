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
	
	
	@Modifying()
	@Query(value="UPDATE EmployeeDataPojo set role=:role where email=:email")
	@Transactional
	void employeeType(@Param("role") String role, @Param("email") String email);
	
	
	@Query("from EmployeeDataPojo where email=?1") 
	EmployeeDataPojo findEmp(String email);
	
	@Query("from EmployeeDataPojo where emp_id=?1") 
	EmployeeDataPojo findEmp(int empId);
	
	
	@Modifying()
	@Query(value="UPDATE EmployeeDataPojo set email=:email,name=:name,surname=:surname,p_number=:pNumber where emp_id=:empId")
	@Transactional
	void updateEmployeeDetails
			(@Param("email") String email,
			@Param("name") String name,
			@Param("surname") String surname,
			@Param("pNumber") String pNumber, 
			@Param("empId") String empId);

}
