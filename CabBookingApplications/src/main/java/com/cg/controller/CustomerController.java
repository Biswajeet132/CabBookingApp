package com.cg.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.cg.model.Customer;
import com.cg.service.ICustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	private ResponseEntity responseEntity;
	private ICustomerService iCustomerService;
	
	@Autowired
	public CustomerController(ICustomerService iCustomerService) {
		this.iCustomerService = iCustomerService;
	}
	
 	@PostMapping("save")
    public ResponseEntity<?> saveCustomer (@RequestBody Customer customer)
    {
	   try {
		   iCustomerService.insertCustomer(customer);
            responseEntity = new ResponseEntity(customer, HttpStatus.CREATED);
        }
        catch(Exception e){
            responseEntity = new ResponseEntity("Error in saving the Customer Data ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }
   	
   	@PutMapping("update")
    public ResponseEntity<?> updateCustomer (@RequestBody Customer customer)throws AdminNotFoundException
    {
	   try {
            
            responseEntity = new ResponseEntity(iCustomerService.updateCustomer(customer), HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity = new ResponseEntity("Error in update the Customer Data ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
   	
   	@DeleteMapping("delete/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
        try {
        	iCustomerService.deleteCustomer(customerId);
            responseEntity = new ResponseEntity("Succesfully deleted", HttpStatus.OK);
        } 
        catch(Exception e){
            responseEntity = new ResponseEntity("Error in deleting the Customer ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }
   	
   	@GetMapping("all")
    public ResponseEntity<?> getAllCustomer() {
        try {
        	
            responseEntity = new ResponseEntity(iCustomerService.viewCustomers(), HttpStatus.OK);
        } 
        catch(Exception e){
            responseEntity = new ResponseEntity("Error to fetch the Customer Details",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }
   	
   	@GetMapping("customer/{customerId}")
    public ResponseEntity<?> getAllCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
        try
        {
        	
            responseEntity = new ResponseEntity(iCustomerService.viewCustomer(customerId), HttpStatus.OK);
        } 
        catch(Exception e){
            responseEntity = new ResponseEntity("Error to fetch the Customer Details by id ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }
       
}
