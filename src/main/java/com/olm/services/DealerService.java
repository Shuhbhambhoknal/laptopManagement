package com.olm.services;

import java.util.List;

import com.olm.models.Dealer;

public interface DealerService {

	public Dealer addDealer(Dealer dealer);

	public Dealer updateDealer(Dealer dealer);

	public Dealer deleteDealer(Long dealerId);

	public List<Dealer> viewAlldealer();

	public Dealer viewDelerById(Long dealerId);

	public Dealer findByLocation(String location);

	Dealer viewDealerByLaptopBrand(String brand);

}
