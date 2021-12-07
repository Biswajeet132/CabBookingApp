package com.cg.service;
import java.time.LocalDateTime;
import java.util.List;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.model.Admin;
import com.cg.model.TripBooking;

public interface IAdminService {

	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException;
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException;
	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException;
	public List<TripBooking> getTripsCabWise();
	public List<TripBooking> getTripsCustomerWise();
	public List<TripBooking> getTripsDateWise();
	public List<TripBooking> getAllTripsForDays(int customerId,LocalDateTime fromDate,LocalDateTime toDate);
}
