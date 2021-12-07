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

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.model.Admin;
import com.cg.service.IAdminService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	private ResponseEntity responseEntity;
	   private IAdminService iAdminService;
	   
	   @Autowired
	   public AdminController(IAdminService iAdminService) {
		this.iAdminService = iAdminService;
	   }
	   
	   	@PostMapping("save")
	    public ResponseEntity<?> saveAdmin (@RequestBody Admin admin)
	    {
		   try {
	            iAdminService.insertAdmin(admin);
	            responseEntity = new ResponseEntity(admin, HttpStatus.CREATED);
	        }
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in saving the Admin Data ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	   	
	   	@PutMapping("update")
	    public ResponseEntity<?> updateAdmin (@RequestBody Admin admin)throws AdminNotFoundException
	    {
		   try {
	            
	            responseEntity = new ResponseEntity(iAdminService.updateAdmin(admin), HttpStatus.OK);
	        }
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in update the Admin Data ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return responseEntity;
	    }
	   	
	   	@DeleteMapping("delete/{adminId}")
	    public ResponseEntity<?> deleteAdmin(@PathVariable int adminId) throws CustomerNotFoundException {
	        try {
	        	iAdminService.deleteAdmin(adminId);
	            responseEntity = new ResponseEntity("Succesfully deleted", HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in deleting the Cards ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }

	 	@GetMapping("trips/{customerId}")
	    public ResponseEntity<?> getAllTrips(@PathVariable int customerId) throws CustomerNotFoundException {
	        try {
	        	
	            responseEntity = new ResponseEntity(iAdminService.getAllTrips(customerId), HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error to fetch the Trip Details",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	 	
	 	@GetMapping("cab")
	    public ResponseEntity<?> getTripsCabWise() {
	        try {
	        	
	            responseEntity = new ResponseEntity(iAdminService.getTripsCabWise(), HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error to fetch the Trip Details",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	 	
		@GetMapping("customer")
	    public ResponseEntity<?> getTripsCustomerWise() {
	        try {
	        	
	            responseEntity = new ResponseEntity(iAdminService.getTripsCustomerWise(), HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error to fetch the Trip Details",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
		
		@GetMapping("date")
	    public ResponseEntity<?> getTripsDateWise() {
	        try {
	        	
	            responseEntity = new ResponseEntity(iAdminService.getTripsDateWise(), HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error to fetch the Trip Details",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	   
}
