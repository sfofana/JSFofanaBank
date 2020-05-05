package com.sfofana.app.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> fileNotFound(BusinessException exception, WebRequest request) {
		return new ResponseEntity<>(new ErrorMessage(exception.getMessage(),"details"), HttpStatus.NOT_FOUND);
	}

}
