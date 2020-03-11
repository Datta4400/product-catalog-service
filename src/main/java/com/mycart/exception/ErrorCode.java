
package com.mycart.exception;



import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    PRODUCT_NOT_FOUND("error.product.not-found"),
	BRAND_NOT_FOUND("error.brand.not-found"),
	CATEGORY_NOT_FOUND("error.category.not-found"),
	PARENT_CATEGORY_NOT_FOUND("error.category.parent-not-found");

    @Getter
    private final String messageCode;

}
