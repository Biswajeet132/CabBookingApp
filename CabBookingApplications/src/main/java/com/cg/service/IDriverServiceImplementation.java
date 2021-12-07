package com.cg.service;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.DriverNotFoundException;
import com.cg.model.Driver;
import com.cg.repository.IDriverRepository;

@Service

public class IDriverServiceImplementation implements IDriverService{
private IDriverRepository iDriverRepository;
	
	@Autowired
	public IDriverServiceImplementation(IDriverRepository iDriverRepository) {
		this.iDriverRepository = iDriverRepository;
	}

	@Override
	public Driver insertDriver(Driver driver) {
		// TODO Auto-generated method stub
		return iDriverRepository.save(driver);
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverNotFoundException {
		// TODO Auto-generated method stub
		if(iDriverRepository.findById(driver.getDriverId()).isEmpty())
		{
			throw new DriverNotFoundException();
		}
		return iDriverRepository.save(driver);
	}

	@Override
	public Driver deleteDriver(int driverId) throws DriverNotFoundException {
		// TODO Auto-generated method stub
		if(iDriverRepository.findById(driverId).isEmpty())
		{
			throw new DriverNotFoundException();
		}
		else
		{
			Driver deleteDriver=iDriverRepository.findById(driverId).get();
			iDriverRepository.deleteById(driverId);
			return deleteDriver;
		}
	}

	@Override
	public List<Driver> viewBestDrivers() {
		// TODO Auto-generated method stub
		List<Driver> bestDriver=iDriverRepository.findAll();
		return bestDriver.stream().filter(driver -> driver.getRating()>=4.5).collect(Collectors.toList());
	}

	//doubt
	@Override
	public Driver viewDriver(int driverId) throws DriverNotFoundException{
		// TODO Auto-generated method stub
		Driver viewDriver;
		if(iDriverRepository.findById(driverId).isEmpty())
		{
			throw new DriverNotFoundException();
		}
		else
		{
			 viewDriver=iDriverRepository.findByDriverId(driverId);
		}
		return viewDriver;
	}

}
