package com.nit.exception;

public class VenueNotActiveException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public VenueNotActiveException(String msg)
	{
		super(msg);
	}
}
