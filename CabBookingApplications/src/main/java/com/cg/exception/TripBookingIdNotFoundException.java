package com.cg.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="Trip Booking id Not Found Exception")
public class TripBookingIdNotFoundException extends Exception{

}
