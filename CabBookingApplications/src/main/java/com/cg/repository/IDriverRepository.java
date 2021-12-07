package com.cg.repository;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.exception.DriverNotFoundException;
import com.cg.model.Cab;
import com.cg.model.Driver;

@Repository

public interface IDriverRepository extends JpaRepository<Driver,Integer> {
	
//	public Driver insertDriver(Driver driver); 
//	public Driver updateDriver(Driver driver)  throws DriverNotFoundException ; 
//	public Driver deleteDriver(int driverId)  throws DriverNotFoundException ; 
//	public List<Driver> viewBestDrivers();
//	public Driver viewDriver(int driverId)  throws DriverNotFoundException;
	public Driver findByDriverId(int driverId);
}
