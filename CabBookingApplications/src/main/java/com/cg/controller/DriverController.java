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
import com.cg.exception.DriverNotFoundException;
import com.cg.model.Customer;
import com.cg.model.Driver;
import com.cg.service.IDriverService;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {
	private ResponseEntity responseEntity;
	private IDriverService iDriverService;
	
	@Autowired
	public DriverController(IDriverService iDriverService) {
		this.iDriverService = iDriverService;
	}
	
	@PostMapping("save")
    public ResponseEntity<?> insertDriver (@RequestBody Driver driver)
    {
	   try {
		   	iDriverService.insertDriver(driver);
            responseEntity = new ResponseEntity(driver, HttpStatus.CREATED);
        }
        catch(Exception e){
            responseEntity = new ResponseEntity("Error in saving the Driver Data ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }
	
	@PutMapping("update")
    public ResponseEntity<?> updateDriver (@RequestBody Driver driver)throws DriverNotFoundException
    {
	   try {
            
            responseEntity = new ResponseEntity(iDriverService.updateDriver(driver), HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity = new ResponseEntity("Error in update the Driver Data ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
   	
 	@DeleteMapping("delete/{driverId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int driverId) throws DriverNotFoundException {
        try {
        	iDriverService.deleteDriver(driverId);
            responseEntity = new ResponseEntity("Succesfully deleted", HttpStatus.OK);
        } 
        catch(Exception e){
            responseEntity = new ResponseEntity("Error in deleting the Driver ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }
	
	@GetMapping("bestdrivers")
    public ResponseEntity<?> getAllDriver() {
        try {
            responseEntity = new ResponseEntity(iDriverService.viewBestDrivers(), HttpStatus.OK);
        } 
        catch(Exception e){
            responseEntity = new ResponseEntity("Error to fetch the Best Drivers",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }
   	
   	@GetMapping("driver/{driverId}")
    public ResponseEntity<?> getAllDriverById(@PathVariable int driverId) throws DriverNotFoundException {
        try
        {
        	
            responseEntity = new ResponseEntity(iDriverService.viewDriver(driverId), HttpStatus.OK);
        } 
        catch(Exception e){
            responseEntity = new ResponseEntity("Error to fetch the Driver Details by id ",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }
	
}
