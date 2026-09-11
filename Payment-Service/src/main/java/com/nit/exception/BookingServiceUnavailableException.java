package com.nit.exception;

public class BookingServiceUnavailableException extends RuntimeException {
	
	public BookingServiceUnavailableException(String msg)
	{
		super(msg);
	}

}
