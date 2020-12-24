package com.pace.wisdom.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.pace.wisdom.exceptions.EmployeeAlreadyExists;
import com.pace.wisdom.exceptions.EmployeeDetailsNotFound;
import com.pace.wisdom.exceptions.EmployeesNotFound;

@ControllerAdvice
public class ExceptionHandlerControlelr {
	@ExceptionHandler(EmployeeAlreadyExists.class)
	public final ResponseEntity<String> employeeAlreadyExists(EmployeeAlreadyExists ex, WebRequest request) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeDetailsNotFound.class)
	public final ResponseEntity<String> employeeDetailsNotFound(EmployeeDetailsNotFound ex, WebRequest request) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeesNotFound.class)
	public final ResponseEntity<String> employeesNotFound(EmployeesNotFound ex, WebRequest request) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> exception(Exception ex, WebRequest request) {
		ex.getStackTrace();
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

}
