package com.olm.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olm.exceptions.InvalidEntityException;
import com.olm.models.Dealer;
import com.olm.repository.DealerRepository;

@Service
public class DealerServiceImpl implements DealerService {
	

		
		@Autowired
		private DealerRepository dealerRepository;
		
		
		
		private static final Logger logger=LoggerFactory.getLogger(DealerServiceImpl.class);

		@Override
		public Dealer addDealer(Dealer dealer)throws InvalidEntityException {
			try {
			if (dealer.getDealerId() != null && dealerRepository.existsById(dealer.getDealerId())) {
				throw new RuntimeException("Dealer with this ID already exists");
			}
			logger.info("Dealer Added Successfully ");
			return dealerRepository.save(dealer);
			// Save new dealer
		}catch(InvalidEntityException e){
			logger.info("Failed to add dealer " + e.getMessage());
			throw e ;
			}
		}
		

		@Override
		public Dealer updateDealer(Dealer dealer) throws InvalidEntityException{
			try {
			Dealer existingDealer = dealerRepository.findById(dealer.getDealerId())
					.orElseThrow(() -> new RuntimeException("Dealer not found"));

			existingDealer.setContactNumber(dealer.getContactNumber());
			existingDealer.setDealerName(dealer.getDealerName());
			existingDealer.setDealershipSignedDate(dealer.getDealershipSignedDate());
			existingDealer.setEmailId(dealer.getEmailId());
			existingDealer.setLocation(dealer.getLocation());

			logger.info("Dealer Update Successfully");
			return dealerRepository.save(existingDealer);
			
		}catch(InvalidEntityException e) {
			logger.info("Failed to update dealer " +e.getMessage());
			throw e;
		}
		}

		@Override
		public Dealer deleteDealer(Long dealerId)throws InvalidEntityException{
			try {
			Dealer dealer = dealerRepository.findById(dealerId)
					.orElseThrow(() -> new RuntimeException("Dealer not found"));

			dealer.setDeleted(true); // Soft delete
			logger.info("Dealer deleted Successfully");

			return dealerRepository.save(dealer); // Save the updated dealer
		}catch(InvalidEntityException e) {
			logger.info("Failed to delete dealer "+e.getMessage());
			throw e;
		}
		}

		@Override
		public List<Dealer> viewAlldealer() {
			logger.info("Successfully getting All delaers");

			return dealerRepository.findAll();
		}

		@Override
		public Dealer viewDelerById(Long dealerId)throws InvalidEntityException {
			try {
			logger.info("Dealer by dealr id fetch successfully " + dealerId);
			return dealerRepository.findById(dealerId)
					.orElseThrow(() -> new RuntimeException("Dealer not found"));
		}catch(InvalidEntityException e) {
			logger.info("failed to get dealer by their id "+e.getMessage());
			throw e;
		}
	}


		@Override
		public Dealer findByLocation(String location) {
			// TODO Auto-generated method stub
			logger.info("Find dealer by location" + location);
			Dealer dealer=dealerRepository.findByLocation(location);
			return dealer;
		}


		@Override
		public Dealer viewDealerByLaptopBrand(String brand) {
			// TODO Auto-generated method stub
			logger.info("Find dealer by Brand" + brand);
			return dealerRepository.findByLaptopsBrand(brand);
		}
		
}
