package com.olm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olm.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


	@Query("SELECT d FROM Department d JOIN d.employeeList e WHERE e.employeeId = :employeeId")
    Department findDepartmentByEmployeeId(@Param("employeeId") Long employeeId);

	List<Department> findDepartmentByBlockAndFloor(String block, Long floor);
	
	

}
