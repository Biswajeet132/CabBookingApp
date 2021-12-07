package com.cg.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.model.Admin;
import com.cg.model.TripBooking;
import com.cg.repository.IAdminRepository;
import com.cg.repository.ITripBookingRepository;

@Service
public class IAdminServiceImplementation implements IAdminService{
	private IAdminRepository iAdminRepository;
	private ITripBookingRepository iTripBookingRepository;
	
	
	@Autowired
	public IAdminServiceImplementation(IAdminRepository iAdminRepository,ITripBookingRepository iTripBookingRepository) {
		this.iAdminRepository = iAdminRepository;
		this.iTripBookingRepository=iTripBookingRepository;
	}

	@Override
	public Admin insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return iAdminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		if(iAdminRepository.findById(admin.getAdminId()).isEmpty())
		{
			throw new AdminNotFoundException();
		}
		return iAdminRepository.save(admin);
	}

	@Override
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException{
		// TODO Auto-generated method stub
		
		if(iAdminRepository.findById(adminId).isEmpty())
		{
			throw new AdminNotFoundException();
		}
		else
		{
			Admin admin=iAdminRepository.findById(adminId).get();
			iAdminRepository.deleteById(adminId);
			return admin;
		}
		
	}

	@Override
	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		if(iAdminRepository.findById(customerId).isEmpty())
		{
			throw new CustomerNotFoundException();
		}
		
		return iTripBookingRepository.findAll();
	}

	@Override
	public List<TripBooking> getTripsCabWise() {
		// TODO Auto-generated method stub
		List<TripBooking> tripCabWiseList=iTripBookingRepository.findAll();
		
		return tripCabWiseList.stream().sorted((a,b)->a.getDriver().getCab().getCabId()-b.getDriver().getCab().getCabId())
				.collect(Collectors.toList());
	}

	@Override
	public List<TripBooking> getTripsCustomerWise() {
		// TODO Auto-generated method stub
		List<TripBooking> tripCustomerWiseList=iTripBookingRepository.findAll();
		return tripCustomerWiseList.stream().sorted((a,b)->a.getCustomerId()-b.getCustomerId())
				.collect(Collectors.toList());
	}

	@Override
	public List<TripBooking> getTripsDateWise() {
		// TODO Auto-generated method stub
		List<TripBooking> tripDateWiseList=iTripBookingRepository.findAll();
		return tripDateWiseList.stream().sorted((a,b)->a.getFromDateTime().compareTo(b.getFromDateTime()))
				.collect(Collectors.toList());
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
