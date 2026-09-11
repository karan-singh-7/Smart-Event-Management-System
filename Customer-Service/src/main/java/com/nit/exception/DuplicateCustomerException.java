package com.nit.exception;

public class DuplicateCustomerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateCustomerException(String msg)
	{
		super(msg);
	}
}
