package com.olm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olm.models.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {

	public Dealer findByLocation(String location);

	public Dealer findByLaptopsBrand(String brand);
	


	
	
	

}
