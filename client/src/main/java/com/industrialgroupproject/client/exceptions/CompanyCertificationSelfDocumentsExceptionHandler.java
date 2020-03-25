package com.industrialgroupproject.client.exceptions;

import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.industrialgroupproject.client.rest.SimpleRestController;

@ControllerAdvice(assignableTypes = {SimpleRestController.class})
public class CompanyCertificationSelfDocumentsExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler
	public ResponseEntity<CompanyCertificationSelfDocumentsErrorResponse> handleException(ConnectException exc) {
		final CompanyCertificationSelfDocumentsErrorResponse error =
				new CompanyCertificationSelfDocumentsErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exc.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public ResponseEntity<CompanyCertificationSelfDocumentsErrorResponse> handleException(HttpClientErrorException exc) {
		final CompanyCertificationSelfDocumentsErrorResponse error =
				new CompanyCertificationSelfDocumentsErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
