package com.healthinsurance.exception;

public class DuplicateException extends RuntimeException
{
	public DuplicateException( String msg)
	{
		super(msg) ;
	}
}