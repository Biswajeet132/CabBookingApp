package com.cg.service;
import java.util.List;

import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.TripBookingIdNotFoundException;
import com.cg.model.TripBooking;

public interface ITripBookingService {
	public TripBooking insertTripBooking(TripBooking tripBooking);
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingIdNotFoundException;
	public TripBooking deleteTripBooking(int tripBookingId) throws TripBookingIdNotFoundException;
	public List<TripBooking> viewAllTripsCustomer(int customerId) throws CustomerNotFoundException;
	public Float calculateBill(int customerId)throws CustomerNotFoundException;

}
