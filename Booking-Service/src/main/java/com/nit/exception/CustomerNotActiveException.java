package com.nit.exception;

public class CustomerNotActiveException extends RuntimeException {

	public CustomerNotActiveException(String msg)
	{
		super(msg);
	}
}
