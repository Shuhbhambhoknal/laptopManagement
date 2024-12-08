package com.olm.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olm.exceptions.InvalidEntityException;
import com.olm.models.Laptop;
import com.olm.repository.LaptopRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LaptopServiceImpl implements LaptopService{
	
	
	private LaptopRepository laptopRepository;
	
	private static final Logger logger=LoggerFactory.getLogger(LaptopServiceImpl.class);
	@Autowired
	private LaptopServiceImpl(LaptopRepository laptopRepository) {
		this.laptopRepository=laptopRepository;
	}

	@Override
	public Laptop addLaptop(Laptop laptop, Long dealerId) throws InvalidEntityException{
		// TODO Auto-generated method stub
		logger.info("Laptop Added Successfully");
		return laptopRepository.save(laptop);
	}

	@Override
	public Laptop updateLaptopStatus(Laptop laptop) throws InvalidEntityException{
		// TODO Auto-generated method stub
		try {
		Laptop update=laptopRepository.findById(laptop.getLaptopId()).orElseThrow(() -> new EntityNotFoundException("Could not found the Laptop Id"));
		if(laptop != null) {
			update.setLaptopStatus(laptop.getLaptopStatus());
			logger.info("Laptop Status updated successfully");
			laptopRepository.save(update);
			
		}
		return update;
	}catch(InvalidEntityException e) {
		throw e;
	}
	}

	@Override
	public List<Laptop> viewAllLaptops() throws InvalidEntityException{
		// TODO Auto-generated method stub
		logger.info("All Laptops fetched Successfully");
		return laptopRepository.findAll();
	}

	@Override
	public Laptop viewLaptopById(Long laptopId) throws InvalidEntityException{
		// TODO Auto-generated method stub
		logger.info("Laptop by id fetched Successfully");
		return laptopRepository.findById(laptopId).orElse(null);
	}


	@Override
	public Laptop deleteLaptop(Long laptopId) throws InvalidEntityException{
		// TODO Auto-generated method stub
		try {
		Laptop delete=laptopRepository.findById(laptopId).orElseThrow(() -> new EntityNotFoundException("Could not found the laptop Id" + laptopId));
		if(delete != null) {
			delete.setDeleted(true);
			logger.info("Laptop deleted Successfully");
			laptopRepository.delete(delete);
		}
		return delete;
	}catch(InvalidEntityException e) {
		throw e;
	}
	}

	@Override
	public Laptop viewLaptopByEmployeeId(Long employeeId) throws InvalidEntityException{
		// TODO Auto-generated method stub
		logger.info("Successfully fetching the laptop by employeeId");
		return laptopRepository.findByEmployeeId(employeeId);
	}

}
