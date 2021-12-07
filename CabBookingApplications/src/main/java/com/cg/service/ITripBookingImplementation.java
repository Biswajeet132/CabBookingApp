package com.cg.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.TripBookingIdNotFoundException;
import com.cg.model.TripBooking;
import com.cg.repository.ITripBookingRepository;

@Service

public class ITripBookingImplementation implements ITripBookingService{
	

	private ITripBookingRepository iTripRepository;
	
	@Autowired
	public ITripBookingImplementation(ITripBookingRepository iTripRepository) {
		this.iTripRepository = iTripRepository;
	}

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		// TODO Auto-generated method stub
		return iTripRepository.save(tripBooking);
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingIdNotFoundException{
		// TODO Auto-generated method stub
		if(iTripRepository.findById(tripBooking.getTripBookingId()).isEmpty())
		{
			throw new TripBookingIdNotFoundException();
		}
		return iTripRepository.save(tripBooking);
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) throws TripBookingIdNotFoundException{
		// TODO Auto-generated method stub
		if(iTripRepository.findById(tripBookingId).isEmpty())
		{
			throw new TripBookingIdNotFoundException();
		}
		else
		{
			TripBooking deleteTripBookingId=iTripRepository.findById(tripBookingId).get();
			iTripRepository.deleteById(tripBookingId);
			return deleteTripBookingId;
		}
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) throws CustomerNotFoundException{
		// TODO Auto-generated method stub
		List<TripBooking> tripBooking;
		if(iTripRepository.findById(customerId).isEmpty())
		{
			throw new CustomerNotFoundException();
		}
		else
		{
			tripBooking= (List<TripBooking>) iTripRepository.findAll();
		}
		return tripBooking;
	}
	

	@Override
	public Float calculateBill(int customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		if(iTripRepository.findById(customerId).isEmpty())
		{
			throw new CustomerNotFoundException();
		}
		else
		{
			List<TripBooking> tripList= this.viewAllTripsCustomer(customerId);
			Optional<Float> totalBill=tripList.stream().map(b -> b.getBill()).reduce((a,b)->a+b);
			return totalBill.get();
		}
	
	}
}
