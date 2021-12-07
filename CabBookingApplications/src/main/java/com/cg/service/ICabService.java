package com.cg.service;
import java.util.List;

import com.cg.exception.CabNotFoundException;
import com.cg.model.Cab;
public interface ICabService {

	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab) throws CabNotFoundException;
	public Cab deleteCab(int cabId) throws CabNotFoundException;
	public List<Cab> viewCabsOfType(String carType);
	public int countCabsOfType(String carType);
}
