package com.mycart.exception;

import java.util.Collection;
import java.util.stream.Collectors;
import static com.mycart.exception.ErrorCode.INVALID_INPUT;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mycart.common.BaseResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandller {

	@Autowired
	private Environment env;

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

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<BaseResponse> handleConstrainstViolationException(final ConstraintViolationException ex) {
		log.error("Bad request {}" + ex);
		Collection<String> errors = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.toList());
		
		
		final BaseResponse resp = getBaseResponseForError(new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_INPUT)) ;
		resp.getErrors().setErrors(errors);
		
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
	}

	@SuppressWarnings("rawtypes")
	private BaseResponse getBaseResponseForError(ProductServiceException e) {
		final BaseResponse resp = new BaseResponse();

		resp.setErrors(buildErrorResponse(e));
		return resp;

	}

	private ErrorResponse buildErrorResponse(ProductServiceException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(e.getErrorCode());
		errorResponse.setMessage(this.env.getProperty(e.getErrorCode().getMessageCode(), e.getErrorCode().name()));
		return errorResponse;
	}

}
