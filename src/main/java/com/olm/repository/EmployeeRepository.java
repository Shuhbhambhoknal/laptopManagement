package com.olm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.olm.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByDepartment_DepartmentName(String departmentName);

	@Query("SELECT e FROM Employee e WHERE e.laptop.id = :laptopId")
	Employee findByLaptopId(Long laptopId);

	// Correct method to search by Laptop brand and model
    List<Employee> findByLaptopBrandAndLaptopModel(String brand, String model);
    
   
}
