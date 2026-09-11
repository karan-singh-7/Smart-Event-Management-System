package com.nit.exception;

public class InvalidSeatUpdateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidSeatUpdateException(String msg)
	{
		super(msg);
	}
}
