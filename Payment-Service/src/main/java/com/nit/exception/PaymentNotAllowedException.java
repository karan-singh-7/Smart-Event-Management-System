package com.nit.exception;

public class PaymentNotAllowedException extends RuntimeException {

	public PaymentNotAllowedException(String msg)
	{
		super(msg);
	}
}
