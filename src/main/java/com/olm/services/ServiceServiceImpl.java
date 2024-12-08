package com.olm.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olm.exceptions.InvalidEntityException;
import com.olm.models.Employee;
import com.olm.models.Services;
import com.olm.repository.EmployeeRepository;
import com.olm.repository.ServiceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceServiceImpl implements ServiceService{
	
	
	private ServiceRepository serviceRepository;
	
	private EmployeeRepository employeeRepository;
	
	private static final Logger logger=LoggerFactory.getLogger(ServiceServiceImpl.class);

	
	@Autowired
	private ServiceServiceImpl(ServiceRepository serviceRepository,EmployeeRepository employeeRepository) {
		this.serviceRepository=serviceRepository;
		this.employeeRepository=employeeRepository;
	}

	@Override
	public Services addService(Services service , Long employeeId) throws InvalidEntityException {
		// TODO Auto-generated method stub
		try {
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
		 service.setEmployee(employee);
		 logger.info("Service Added Successfully");
		return serviceRepository.save(service);
	}
		catch(InvalidEntityException e) {
			throw e;
		}
	}

	@Override
	public Services updateServiceStatus(Long serviceId, String serviceStatus) throws InvalidEntityException {
		// TODO Auto-generated method stub
		try {
		Services update=serviceRepository.findById(serviceId).orElseThrow(() -> new EntityNotFoundException("Could not find serviceId "+ serviceId));
		if(update != null ) {
			update.setServiceStatus(serviceStatus);
			serviceRepository.save(update);
		}
		 logger.info("Service updated Successfully");

		return update;
	}catch(InvalidEntityException e) {
		throw e;
	}
	}

	@Override
	public List<Services> viewAllServices() throws InvalidEntityException{
		// TODO Auto-generated method stub
		try {
		 logger.info("All Services fetched Successfully");

		return serviceRepository.findAll();
	}catch(InvalidEntityException e) {
		logger.info("Failed to get all services "+ e.getMessage());
		throw e;
	}
	}

	@Override
	public Services viewServiceById(Long serviceId) {
		// TODO Auto-generated method stub
		 logger.info("Service by id fetched Successfully");

		return serviceRepository.findById(serviceId).orElseThrow(() -> new EntityNotFoundException("Could not find the service Id " + serviceId));
	}

	@Override
	public Services deleteServices(Long serviceId) throws InvalidEntityException {
		// TODO Auto-generated method stub
		try {
		Services delete=serviceRepository.findById(serviceId).orElseThrow(() -> new EntityNotFoundException("Service not found with id: " + serviceId));
		if(delete != null) {
			delete.setIsDeleted(true);
			logger.info("service  Deleted Successfully ");
			serviceRepository.save(delete);
		}
		return delete;
	}catch(InvalidEntityException ex) {
		logger.info("Failed to delete service" + ex.getMessage());
		throw ex;
	}
	}

}
