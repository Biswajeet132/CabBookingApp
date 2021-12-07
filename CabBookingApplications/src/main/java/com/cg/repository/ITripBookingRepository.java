package com.cg.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.TripBookingIdNotFoundException;
import com.cg.model.TripBooking;

@Repository
public interface ITripBookingRepository extends JpaRepository<TripBooking, Integer> {
//	public TripBooking insertTripBooking(TripBooking tripBooking);
//	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingIdNotFoundException;
//	public TripBooking deleteTripBooking(int tripBookingId) throws TripBookingIdNotFoundException;
//	public List<TripBooking> viewAllTripsCustomer(int customerId)throws CustomerNotFoundException;
//	public TripBooking calculateBill(int customerId)throws CustomerNotFoundException;
	
	
}
