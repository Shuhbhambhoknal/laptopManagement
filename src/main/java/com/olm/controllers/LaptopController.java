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
import com.olm.models.Laptop;
import com.olm.services.LaptopService;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
	
	@Autowired
	private LaptopService laptopService;
	
	@PostMapping("/add/{dealerId}")
	public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop laptop, @PathVariable Long dealerId)throws InvalidEntityException{
		Laptop add=laptopService.addLaptop(laptop,dealerId);
		return new ResponseEntity<Laptop>(add , HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop laptop)throws InvalidEntityException{
		Laptop upd=laptopService.updateLaptopStatus(laptop);
		return new ResponseEntity<Laptop>(upd , HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{laptopId}")
	public ResponseEntity<Laptop> deleteLaptop(@PathVariable Long laptopId)throws InvalidEntityException{
		Laptop del=laptopService.deleteLaptop(laptopId);
		return new ResponseEntity<Laptop>(del , HttpStatus.OK);
	}
	
	@GetMapping("/view/{laptopId}")
	public ResponseEntity<Laptop> viewLaptopById(@PathVariable Long laptopId)throws InvalidEntityException{
		Laptop viewById=laptopService.viewLaptopById(laptopId);
		return new ResponseEntity<Laptop>(viewById , HttpStatus.OK);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Laptop>> viewAllLaptop()throws InvalidEntityException{
		List<Laptop> all=laptopService.viewAllLaptops();
		return new ResponseEntity<List<Laptop>>(all , HttpStatus.OK);
	}
	
	@GetMapping("/view/{employeeId}")
	public ResponseEntity<Laptop> viewLaptopByEmployeeId(@PathVariable Long employeeId)throws InvalidEntityException{
		Laptop viewById=laptopService.viewLaptopByEmployeeId(employeeId);
		return new ResponseEntity<Laptop>(viewById , HttpStatus.OK);
	}


}
