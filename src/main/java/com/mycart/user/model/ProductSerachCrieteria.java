package com.mycart.user.model;

import com.mycart.common.SearchType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductSerachCrieteria {
	
	private SearchType searchType ;
	private String operation ;
	private Object value ;
	public boolean isOrPredicate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
