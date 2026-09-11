package com.nit.exception;

public class BookingNotFoundException extends RuntimeException {

	public BookingNotFoundException(String msg)
	{
		super(msg);
	}
}
