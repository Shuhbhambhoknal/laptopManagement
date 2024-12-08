package com.olm.services;

import java.util.List;

import com.olm.models.Laptop;

public interface LaptopService {

	public Laptop addLaptop(Laptop laptop , Long dealerId);  

	public Laptop updateLaptopStatus(Laptop laptop);
	
	public Laptop deleteLaptop(Long laptopId);

	public List<Laptop> viewAllLaptops();

	public Laptop viewLaptopById(Long laptopId);
	
	public Laptop viewLaptopByEmployeeId(Long employeeId);

	
	

}
