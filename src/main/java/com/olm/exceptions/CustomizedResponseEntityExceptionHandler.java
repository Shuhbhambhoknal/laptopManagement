package com.olm.exceptions;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidEntityException.class)
	public final ResponseEntity<ExceptionResponse> handleInvalidEntityException(InvalidEntityException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false), "300 Invalid server Error");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex, WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), "404 Not Found Error");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlleAllException(Exception ex , WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(LocalDateTime.now(), ex.getMessage() , request.getDescription(false) , "500 Internal Server Error");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}