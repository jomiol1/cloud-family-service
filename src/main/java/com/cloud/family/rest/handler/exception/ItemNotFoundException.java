package com.cloud.family.rest.handler.exception;

public class ItemNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7983081447624040990L;
	
    public ItemNotFoundException(final String message) {
        super(message);
    }

}
