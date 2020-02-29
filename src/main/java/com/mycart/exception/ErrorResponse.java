
package com.mycart.exception;

import java.util.Collection;

import org.slf4j.MDC;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

    private String traceId = MDC.get("X-B3-TraceId");

    private ErrorCode errorCode;

    private String message;

    private String detailedMessage;

    private Collection<String> errors;

}
