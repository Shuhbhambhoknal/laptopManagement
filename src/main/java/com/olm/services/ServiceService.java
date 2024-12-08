package com.olm.services;

import java.util.List;


import com.olm.models.Services;

public interface ServiceService {

	public Services addService(Services service , Long employeeId);

	public Services updateServiceStatus(Long serviceId, String serviceStatus);
	
	public Services deleteServices(Long serviceId);

	public List<Services> viewAllServices();

	public Services viewServiceById(Long serviceId);


}
