package com.nit.exception;

public class InsufficientSeatsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsufficientSeatsException(String msg)
	{
		super(msg);
	}
}
