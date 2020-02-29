package com.mycart.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mycart.common.BaseResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandller {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<BaseResponse> handleException(final ProductServiceException ex) {
		log.error("Exception occured" + ex);
		BaseResponse baseResponse = new BaseResponse<>();
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorCode());
		baseResponse.setErrors(errorResponse);

		return new ResponseEntity<>(baseResponse, ex.getStatus());

	}

}
