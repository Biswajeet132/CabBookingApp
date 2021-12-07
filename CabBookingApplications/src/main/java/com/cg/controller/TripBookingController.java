package com.cg.controller;
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

import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.TripBookingIdNotFoundException;
import com.cg.model.TripBooking;
import com.cg.service.ITripBookingService;

@RestController
@RequestMapping("/api/v1/tripbooking")
public class TripBookingController {
	private ResponseEntity responseEntity;
	 private ITripBookingService iTripBookingService;
	 
	 @Autowired
	 public TripBookingController(ITripBookingService iTripBookingService) {
		this.iTripBookingService = iTripBookingService;
	}
	 
	  	@PostMapping("save")
	    public ResponseEntity<?> insertTripBooking (@RequestBody TripBooking tripBooking)
	    {
		   try {
			   	iTripBookingService.insertTripBooking(tripBooking);
	            responseEntity = new ResponseEntity(tripBooking, HttpStatus.CREATED);
	        }
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in saving the Admin Data ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	   	
	   	@PutMapping("update")
	    public ResponseEntity<?> updateAdmin (@RequestBody TripBooking tripBooking)throws TripBookingIdNotFoundException
	    {
		   try {
	            
	            responseEntity = new ResponseEntity(iTripBookingService.updateTripBooking(tripBooking), HttpStatus.OK);
	        }
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in update the Trip Booking Data ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return responseEntity;
	    }
	   	
	   	@DeleteMapping("delete/{tripBookingId}")
	    public ResponseEntity<?> deleteTripBooking(@PathVariable int tripBookingId) throws TripBookingIdNotFoundException {
	        try {
	        	iTripBookingService.deleteTripBooking(tripBookingId);
	            responseEntity = new ResponseEntity("Succesfully deleted", HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in deleting the Cards ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	 
	   	@GetMapping("view/{customerId}")
	    public ResponseEntity<?> viewAllTripsCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
	        try {
	        	
	            responseEntity = new ResponseEntity(iTripBookingService.viewAllTripsCustomer(customerId), HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in fetching the trip details ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	   	
	 	@GetMapping("bill/{customerId}")
	    public ResponseEntity<?> calculateBill(@PathVariable int customerId) throws CustomerNotFoundException {
	        try {
	        	
	            responseEntity = new ResponseEntity(iTripBookingService.calculateBill(customerId), HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in fetching the bill details ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
}
