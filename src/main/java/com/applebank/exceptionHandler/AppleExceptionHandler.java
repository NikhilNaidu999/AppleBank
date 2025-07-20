package com.applebank.exceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.applebank.exception.DepartmentNotFoundException;
import com.applebank.exception.EmployeeDoesNotExistException;
import com.applebank.exception.EmployeeNotFoundException;
import com.applebank.exception.LeaveNotFoundException;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestControllerAdvice
public class AppleExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({DepartmentNotFoundException.class,
		EmployeeDoesNotExistException.class,
		EmployeeNotFoundException.class,
		LeaveNotFoundException.class})
	public ResponseEntity<Map<String,String>> handleCustomExceptions(RuntimeException  exception){
		Map<String,String> errorResponse =new HashMap<>();
		errorResponse.put("error message ", exception.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String,String> errors  =new HashMap<>();
		List<ObjectError> objectErrors=ex.getBindingResult().getAllErrors();
		for(ObjectError fieldError:objectErrors) {
			errors.put(fieldError.getObjectName(), fieldError.getDefaultMessage());
		}
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
	
}
