
package com.mycart.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mycart.exception.ErrorResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {

    private T data;

    @JsonInclude(Include.NON_EMPTY)

    private ErrorResponse errors;
}
