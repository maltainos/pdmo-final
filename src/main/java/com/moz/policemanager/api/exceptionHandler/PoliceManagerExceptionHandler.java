package com.moz.policemanager.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.moz.policemanager.ui.response.ResponseException;

@ControllerAdvice
public class PoliceManagerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var fields = new ArrayList<ResponseException.Field>();
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String field = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			fields.add(new ResponseException.Field(field,message));
		}
		ResponseException responseException = new ResponseException();
		responseException.setDateTime(LocalDateTime.now());
		responseException.setStatus(status.value());
		responseException.setMessage("Um ou mais campos estao invalidos. Faca o preenchimento correcto e tente novamente!");
		responseException.setFields(fields);
			
		return super.handleExceptionInternal(ex,responseException,headers,status, request);
	}

}








