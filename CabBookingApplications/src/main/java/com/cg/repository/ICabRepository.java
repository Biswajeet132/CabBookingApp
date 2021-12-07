package com.cg.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.exception.CabNotFoundException;
import com.cg.model.Cab;

@Repository
public interface ICabRepository extends JpaRepository<Cab, Integer>{
//	public Cab insertCab(Cab cab);
//	public Cab updateCab(Cab cab) throws CabNotFoundException;
//	public Cab deleteCab(int cabId) throws CabNotFoundException;
//	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
//	public int countCabsOfType(String carType);
	public List<Cab> findByCarType(String carType);
}
