package com.user.service.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.payLoad.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(){
		return null;
		
	}

}
