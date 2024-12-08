package com.olm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olm.exceptions.InvalidEntityException;
import com.olm.models.Employee;
import com.olm.services.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/add/{departmentId}/{laptopId}")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee,@PathVariable Long departmentId,@PathVariable Long laptopId)throws InvalidEntityException{
		Employee add=employeeService.addEmployee(employee,departmentId,laptopId);
		return new ResponseEntity<Employee>(add , HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{employeeId}/{designation}")
	public ResponseEntity<Employee> updateDesignation(@PathVariable Long employeeId ,@PathVariable String designation)throws InvalidEntityException{
		Employee update=employeeService.updateDesignation(employeeId ,designation);
		return new ResponseEntity<Employee>(update , HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{employeeId}")
	public ResponseEntity<Employee> viewEmployeeById(@PathVariable Long employeeId)throws InvalidEntityException{
		Employee view=employeeService.viewEmployeeById(employeeId);
		return new ResponseEntity<Employee>(view , HttpStatus.OK);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Employee>> viewAllEmployees()throws InvalidEntityException{
		List<Employee> all=employeeService.viewAllEmployees();
		return new ResponseEntity<List<Employee>>(all , HttpStatus.OK);
	}
	
	@GetMapping("/viewAllEmployeeByDepartment/{department}")
	public ResponseEntity<List<Employee>> viewAllEmployeesByDepartment(@PathVariable String departmentIdName)throws InvalidEntityException{
		List<Employee> all=employeeService.viewAllEmployeesByDepartment(departmentIdName);
		return new ResponseEntity<List<Employee>>(all , HttpStatus.OK);
	}
	
	@GetMapping("/viewByLaptopId/{laptopId}")
	public ResponseEntity<Employee> viewEmployeeByLaptopId(@PathVariable Long laptopId)throws InvalidEntityException{
		Employee view=employeeService.viewEmployeeByLaptopId(laptopId);
		return new ResponseEntity<Employee>(view , HttpStatus.OK);
	}
	
	
	@GetMapping("/viewByBrandModel/{brand}/{model}")
	public ResponseEntity<List<Employee>> viewEmployeeByLaptopBrandAndModel(@PathVariable String brand,@PathVariable String model)throws InvalidEntityException{
		List<Employee> view=employeeService.viewEmployeeByLaptopBrandAndModel(brand, model);
		return new ResponseEntity<List<Employee>>(view,HttpStatus.OK);
	}

}
