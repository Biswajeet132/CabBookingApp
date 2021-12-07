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

import com.cg.exception.CabNotFoundException;
import com.cg.model.Cab;
import com.cg.service.ICabService;


@RestController
@RequestMapping("/api/v1/cab")
public class CabController {
	 private ResponseEntity responseEntity;
	  private ICabService iCabService;
	  
	  @Autowired
	  public CabController(ICabService iCabService) {
		this.iCabService = iCabService;
	  }
	  
	 	@PostMapping("save")
	    public ResponseEntity<?> saveCab (@RequestBody Cab cab)
	    {
		   try {
			    iCabService.insertCab(cab);
	            responseEntity = new ResponseEntity(cab, HttpStatus.CREATED);
	        }
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in saving the Cab Data ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	   	
	   	@PutMapping("update")
	    public ResponseEntity<?> updateCab (@RequestBody Cab cab)throws CabNotFoundException
	    {
		   try {
	            
	            responseEntity = new ResponseEntity(iCabService.updateCab(cab), HttpStatus.OK);
	        }
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in update the Cab Data ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return responseEntity;
	    }
	   	
	   	@DeleteMapping("delete/{cabId}")
	    public ResponseEntity<?> deleteCab(@PathVariable int cabId) throws CabNotFoundException {
	        try {
	        	iCabService.deleteCab(cabId);
	            responseEntity = new ResponseEntity("Succesfully deleted", HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in deleting the Cards ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	  
	 	@GetMapping("cabstype/{carType}")
	   	public ResponseEntity<?> viewCabsOfType(@PathVariable String carType) throws CabNotFoundException {
	        try {
	        	
	            responseEntity = new ResponseEntity(iCabService.viewCabsOfType(carType), HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error  ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
	 	
		@GetMapping("count/{carType}")
	   	public ResponseEntity<?> countCabsOfType(@PathVariable String carType) throws CabNotFoundException {
	        try {
	            responseEntity = new ResponseEntity(iCabService.countCabsOfType(carType), HttpStatus.OK);
	        } 
	        catch(Exception e){
	            responseEntity = new ResponseEntity("Error in count ",HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        return  responseEntity;
	    }
}
