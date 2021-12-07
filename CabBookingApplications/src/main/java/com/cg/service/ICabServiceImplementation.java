package com.cg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CabNotFoundException;
import com.cg.model.Admin;
import com.cg.model.Cab;
import com.cg.repository.ICabRepository;

@Service
public class ICabServiceImplementation implements ICabService{
private ICabRepository iCabRepository;
	
	
	@Autowired
	public ICabServiceImplementation(ICabRepository iCabRepository) {
		this.iCabRepository = iCabRepository;
	}

	@Override
	public Cab insertCab(Cab cab) {
		// TODO Auto-generated method stub
		return iCabRepository.save(cab);
	}

	@Override
	public Cab updateCab(Cab cab) throws CabNotFoundException{
		// TODO Auto-generated method stub
		if(iCabRepository.findById(cab.getCabId()).isEmpty())
		{
			throw new CabNotFoundException();
		}
		return iCabRepository.save(cab);
	}

	@Override
	public Cab deleteCab(int cabId) throws CabNotFoundException {
		// TODO Auto-generated method stub
		if(iCabRepository.findById(cabId).isEmpty())
		{
			throw new CabNotFoundException();
		}
		else
		{
			Cab cab=iCabRepository.findById(cabId).get();
			iCabRepository.deleteById(cabId);
			return cab;
		}
	}

	@Override
	public List<Cab> viewCabsOfType(String carType)  {
		// TODO Auto-generated method stub
		List<Cab> cabType=iCabRepository.findByCarType(carType);
		return cabType;
		
	}

	@Override
	public int countCabsOfType(String carType) {
		// TODO Auto-generated method stub
		List<Cab> cabType=iCabRepository.findByCarType(carType);
		
		return (int) cabType.stream().count();
	}

}
