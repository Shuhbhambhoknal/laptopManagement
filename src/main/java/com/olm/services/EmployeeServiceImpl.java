package com.olm.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olm.exceptions.InvalidEntityException;
import com.olm.models.Employee;
import com.olm.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;

	}

	@Override
	public Employee addEmployee(Employee employee, Long departmentId, Long laptopId) {

		// TODO Auto-generated method stub
		logger.info("Employee Added Successfully");
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateDesignation(Long employeeId ,String designation)throws InvalidEntityException {
		// TODO Auto-generated method stub
		try{
		Employee update=employeeRepository.findById(employeeId).orElseThrow(()-> new EntityNotFoundException("Could not found employee Id"));
		if( update != null) {
			update.setDesignation(designation);
			logger.info("Successfully updated the employee Designation");
			employeeRepository.save(update);
		}
		logger.info("Departmnet updated Successfully");
		return update;
	}catch(InvalidEntityException e) {
		throw e;
			
		}
	}

	@Override
	public Employee viewEmployeeById(Long employeeId) throws InvalidEntityException {
		// TODO Auto-generated method stub
		logger.info("employee  id fetched  Successfully " + employeeId);
		return employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Could not find the employee Id"));
	}

	@Override
	public List<Employee> viewAllEmployees() {
		// TODO Auto-generated method stub
		logger.info("All Employee fetched Successfully");
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> viewAllEmployeesByDepartment(String departmentIdName) {
		logger.info("Successfully fetched employee by department Name");
		return employeeRepository.findByDepartment_DepartmentName(departmentIdName);

	}

	@Override
	public Employee viewEmployeeByLaptopId(Long laptopId) {
		// TODO Auto-generated method stub
		logger.info("Successfully fetched employee by Laptop Id");
		return employeeRepository.findByLaptopId(laptopId);
	}

	@Override
	public List<Employee> viewEmployeeByLaptopBrandAndModel(String brand, String model) {
		// TODO Auto-generated method stub
		logger.info("Successfully fetched employee by their Laptop  brand and model");
		return employeeRepository.findByLaptopBrandAndLaptopModel(brand, model);
	}
}
