package com.olm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olm.exceptions.InvalidEntityException;
import com.olm.models.Dealer;
import com.olm.services.DealerService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/dealer")
public class DealerController {
	
	@Autowired
	private DealerService dealerService;
	

	
	// Adding new Department
		@PostMapping("/admin/add")
		public ResponseEntity<Dealer> addDealer( @RequestBody Dealer dealer)throws InvalidEntityException{
			Dealer add=dealerService.addDealer(dealer);
			return new ResponseEntity<Dealer>(add , HttpStatus.CREATED);
		}
		
		@PutMapping("/update")
		public ResponseEntity<Dealer> updateDealer(@RequestBody Dealer dealer)throws InvalidEntityException{
			Dealer update=dealerService.updateDealer(dealer);
			return new ResponseEntity<Dealer>(update , HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{dealerId}")
		public ResponseEntity<Dealer> deleteDealer(@PathVariable Long dealerId)throws InvalidEntityException{
			Dealer del=dealerService.deleteDealer(dealerId);
			return new ResponseEntity<Dealer>(del , HttpStatus.OK);
		}
		
		@GetMapping("/view/{dealerId}")
		public ResponseEntity<Dealer> viewDealerById(@PathVariable Long dealerId)throws InvalidEntityException{
		
			Dealer view=dealerService.viewDelerById(dealerId);
			return new ResponseEntity<Dealer>(view , HttpStatus.OK);
		}
		
		@GetMapping("/viewAll")
		public ResponseEntity<List<Dealer>> viewAllDealers(){
			List<Dealer> all=dealerService.viewAlldealer();
			return new ResponseEntity<List<Dealer>>(all , HttpStatus.OK);
		}
		
		@GetMapping("/viewby/{location}")
		public ResponseEntity<Dealer> viewDealerByLocation(@PathVariable String location)throws InvalidEntityException{
		
			Dealer view=dealerService.findByLocation(location);
			return new ResponseEntity<Dealer>(view , HttpStatus.OK);
		}
		
		@GetMapping("/viewbyy/{brand}")
		public ResponseEntity<Dealer> viewDealerByLaptopBrand(@PathVariable String brand){
		
			Dealer view=dealerService.viewDealerByLaptopBrand(brand);
			return ResponseEntity.ok(view);
		}

}
