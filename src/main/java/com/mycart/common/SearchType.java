package com.mycart.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchType {
	BRAND("brand"),
	PRICE("price"),
	COLOR("color"),
	SIZE("size"),
	SKU("sku"),
	COUNT("count");
	
	private String searchType ;
	
	public static SearchType fromString(String text) {
        for (SearchType b : SearchType.values()) {
            if (b.searchType.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
	
}
