package com.olm.services;

import java.util.List;

import com.olm.models.Department;

public interface DepartmentService {
	
	public Department addDepartment(Department department);
	
	public Department updateBlock(Long departmentId, String block);
	
	public Department deleteDepartment(Long departmentId);
	
	public List<Department> viewAllDepartments();
	
	public Department viewDepartmentById(Long departmentId);
	
	public List<Department> viewDepartmentsByBlockAndFloor(String block, Long floor);

	public Department viewDepartmentByEmployeeId(Long employeeId);
//	
//	public List<Department> viewDepartmentWithMinimumServiceCount();
//	
//	public Map<String,Integer> getLaptopCountDepartmentwise();

}
