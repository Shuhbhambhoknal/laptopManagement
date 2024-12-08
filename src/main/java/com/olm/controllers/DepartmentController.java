package com.olm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olm.exceptions.InvalidEntityException;
import com.olm.models.Department;
import com.olm.services.DepartmentService;


@RestController
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	// Adding new Department
	@PostMapping("/add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department)throws InvalidEntityException{
		Department add=departmentService.addDepartment(department);
		return new ResponseEntity<Department>(add , HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{departmentId}/{block}")
	public ResponseEntity<Department> updateBlock(@PathVariable Long departmentId, @PathVariable String  block )throws InvalidEntityException{
		Department update=departmentService.updateBlock(departmentId, block);
		return new ResponseEntity<Department>(update , HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{departmentId}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable Long departmentId)throws InvalidEntityException{
		Department del=departmentService.deleteDepartment(departmentId);
		return new ResponseEntity<Department>(del , HttpStatus.OK);
	}
	
	@GetMapping("/view/{departmentId}")
	public ResponseEntity<Department> viewDepartmentById(@PathVariable Long departmentId)throws InvalidEntityException{
		Department view=departmentService.viewDepartmentById(departmentId);
		return new ResponseEntity<Department>(view , HttpStatus.OK);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Department>> viewAllDepartments()throws InvalidEntityException{
		List<Department> all=departmentService.viewAllDepartments();
		return new ResponseEntity<List<Department>>(all , HttpStatus.OK);
	}
	
	
	@GetMapping("/viewBy/{employeeId}")
	public ResponseEntity<Department> viewDepartmentByEmployeeId(@PathVariable Long employeeId){
		Department all=departmentService.viewDepartmentByEmployeeId(employeeId);
		return new ResponseEntity<Department>(all , HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{block}/{floor}")
	public ResponseEntity<List<Department>> viewDepartmentsByBlockAndFloor(@PathVariable String block,@PathVariable Long floor){
		List<Department> all=departmentService.viewDepartmentsByBlockAndFloor(block, floor);
		return ResponseEntity.ok(all);
	}
	
	
	
	
	

}
