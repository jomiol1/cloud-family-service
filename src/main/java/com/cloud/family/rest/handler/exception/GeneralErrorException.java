package com.cloud.family.rest.handler.exception;

public class GeneralErrorException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1023164679761486852L;
	
    public GeneralErrorException(final String message) {
        super(message);
    }

}
