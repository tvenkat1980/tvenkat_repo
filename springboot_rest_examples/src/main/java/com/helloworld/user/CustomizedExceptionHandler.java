package com.helloworld.user;

import java.util.Date;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler 
{
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<UserException> handleAllExceptions(Exception ex, WebRequest request) 
	{
		UserException userException = new UserException(new Date(), ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity<UserException>(userException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {UserNotFoundException.class, EmptyResultDataAccessException.class})
	public ResponseEntity<UserException> handleCustomizedException(Exception ex, WebRequest request) 
	{
		UserException userException = new UserException(new Date(), ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity<UserException>(userException, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		UserException userException = new UserException(new Date(), ex.getMessage(), 
				ex.getBindingResult().toString());
		
		return new ResponseEntity<Object>(userException, HttpStatus.BAD_REQUEST);
	}
}
