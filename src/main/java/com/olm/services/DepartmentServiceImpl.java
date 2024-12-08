package com.olm.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olm.exceptions.InvalidEntityException;
import com.olm.models.Department;
import com.olm.repository.DepartmentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(DealerServiceImpl.class);

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department addDepartment(Department department) throws InvalidEntityException {
		// TODO Auto-generated method stub
		try {
			logger.info("Departmnet Added Successfully");
			return departmentRepository.save(department);
		} catch (InvalidEntityException e) {
			logger.info("Failed to add departments" + e.getMessage());
			throw e;
		}

	}

	@Override
	public Department updateBlock(Long departmentId, String block) throws InvalidEntityException {
		// TODO Auto-generated method stub
		try {
			Department dept = departmentRepository.findById(departmentId).orElse(null);
			if (dept != null) {
				dept.setBlock(block);
				departmentRepository.save(dept);
			}
			logger.info("Departmnet updated Successfully");
			return dept;
		} catch (InvalidEntityException e) {
			logger.info("Failed to update department" + e.getMessage());
			throw e;
		}
	}

	@Override
	public Department deleteDepartment(Long departmentId) throws InvalidEntityException {
		try {
			Department dept = departmentRepository.findById(departmentId).orElse(null);
			if (dept != null) {
				departmentRepository.delete(dept);
			}
			logger.info("Departmnet deleted Successfully");
			return dept;
		} catch (InvalidEntityException e) {
			logger.info("failed to delete Department" + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Department> viewAllDepartments() throws InvalidEntityException {
		try {
			// TODO Auto-generated method stub
			logger.info("All Departmnet fetched Successfully ");
			return departmentRepository.findAll();
		} catch (InvalidEntityException e) {
			logger.info("failed to get department By Id" + e.getMessage());
			throw e;
		}
	}

	@Override
	public Department viewDepartmentById(Long departmentId) throws InvalidEntityException {
		try {
			// TODO Auto-generated method stub
			logger.info("Departmnet id fatched  Successfully " + departmentId);
			return departmentRepository.findById(departmentId)
					.orElseThrow(() -> new EntityNotFoundException(" Could not found Department Id : " + departmentId));
		} catch (InvalidEntityException e) {
			logger.info("failed to get all department" + e.getMessage());
			throw e;

		}
	}

	@Override
	public Department viewDepartmentByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		logger.info("fetched successfully departments by employee Id " + employeeId);
		return departmentRepository.findDepartmentByEmployeeId(employeeId);
	}

	@Override
	public List<Department> viewDepartmentsByBlockAndFloor(String block, Long floor) {
		// TODO Auto-generated method stub
		logger.info("fetched successfully departments by Block and floor");
		return departmentRepository.findDepartmentByBlockAndFloor(block, floor);
	}

}
