package com.user.service.Exception;

public class ResourceNotFoundException extends RuntimeException {
	
	
	//extra properties that you want to manange
	
	public ResourceNotFoundException() {
		super("resouce not found exception");
	}
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
