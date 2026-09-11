package com.nit.exception;

public class InsufficientSeatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsufficientSeatException(String msg)
	{
		super(msg);
	}
}
