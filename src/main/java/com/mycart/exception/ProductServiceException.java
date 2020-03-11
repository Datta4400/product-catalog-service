package com.mycart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;
import lombok.NonNull;


public class ProductServiceException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public ProductServiceException(HttpStatus status, ErrorCode errorCode) {
		super(status, errorCode.getMessageCode());
		this.errorCode = errorCode;
		// TODO Auto-generated constructor stub
	}

	@Getter
	@NonNull
	private final ErrorCode errorCode;

}
