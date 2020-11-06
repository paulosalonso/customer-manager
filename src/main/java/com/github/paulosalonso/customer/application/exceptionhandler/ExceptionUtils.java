package com.github.paulosalonso.customer.application.exceptionhandler;

public class ExceptionUtils {

	public static Throwable getRootCause(Throwable throwable) {
		
		if (throwable.getCause() != null)
			return getRootCause(throwable.getCause());
		
		return throwable;
		
	}
	
}
