package com.olm.services;

import java.util.List;

import com.olm.models.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee, Long departmentId, Long laptopId);

	public Employee updateDesignation(Long employeeId, String designation);

	public Employee viewEmployeeById(Long employeeId);

	public List<Employee> viewAllEmployees();

	public List<Employee> viewAllEmployeesByDepartment(String departmentIdName);

	public Employee viewEmployeeByLaptopId(Long laptopId);

	public List<Employee> viewEmployeeByLaptopBrandAndModel(String brand, String model);

}
