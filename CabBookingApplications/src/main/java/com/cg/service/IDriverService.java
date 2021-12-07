package com.cg.service;
import java.util.List;
import java.util.function.Supplier;

import com.cg.exception.DriverNotFoundException;
import com.cg.model.Driver;

public interface IDriverService {
	public Driver insertDriver(Driver driver); 
	public Driver updateDriver(Driver driver)  throws DriverNotFoundException ; 
	public Driver deleteDriver(int driverId) throws DriverNotFoundException ; 
	public List<Driver> viewBestDrivers();
	public Driver viewDriver(int driverId)  throws DriverNotFoundException;
}
