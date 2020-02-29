
package com.mycart.exception;



import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    PRODUCT_NOT_FOUND("error.dashboard.allready-exists");

    @Getter
    private final String messageCode;

}
