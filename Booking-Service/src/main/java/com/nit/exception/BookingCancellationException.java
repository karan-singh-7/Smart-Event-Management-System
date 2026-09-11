package com.nit.exception;

public class BookingCancellationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookingCancellationException(String msg)
	{
		super(msg);
	}
}
