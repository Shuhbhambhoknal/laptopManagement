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
import com.olm.models.Services;
import com.olm.services.ServiceService;

@RestController
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private ServiceService serviceService;
	
	@PostMapping("/add/{employeeId}")
	public ResponseEntity<Services> addService(@RequestBody Services service , @PathVariable Long employeeId)throws InvalidEntityException{
		Services add=serviceService.addService(service,employeeId);
		return new ResponseEntity<Services>(add , HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{serviceId}/{serviceStatus}")
	public ResponseEntity<Services> updateDealer(@PathVariable Long serviceId,@PathVariable String serviceStatus)throws InvalidEntityException{
		Services update=serviceService.updateServiceStatus(serviceId,serviceStatus);
		return new ResponseEntity<Services>(update , HttpStatus.OK);
	}
	
//	@DeleteMapping("/delete/{dealerId}")
//	public ResponseEntity<Service> deleteDealer(@PathVariable Long dealerId){
//		Service del=dealerService.deleteDealer(dealerId);
//		return new ResponseEntity<Service>(del , HttpStatus.OK);
//	}
	
	@GetMapping("/view/{serviceId}")
	public ResponseEntity<Services> viewServiceById(@PathVariable Long serviceId)throws InvalidEntityException{
		Services view=serviceService.viewServiceById(serviceId);
		return new ResponseEntity<Services>(view , HttpStatus.OK);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Services>> viewAllServices()throws InvalidEntityException{
		List<Services> all=serviceService.viewAllServices();
		return new ResponseEntity<List<Services>>(all , HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{serviceId}")
	public ResponseEntity<Services> deleteService(@PathVariable long serviceId)throws InvalidEntityException{
		Services delete=serviceService.deleteServices(serviceId);
		return new ResponseEntity<Services>(delete,HttpStatus.OK);
	}
	
} 
