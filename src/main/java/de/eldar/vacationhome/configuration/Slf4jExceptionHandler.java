package de.eldar.vacationhome.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class Slf4jExceptionHandler {

	/**
	 * Every Exception we have not handled until this resolves will be 500. 
	 * 
	 * @param e The delinquent
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public void handleException(Exception e) {
		log.error("Caught exception in MVC stack: ", e);
	}
	
}
