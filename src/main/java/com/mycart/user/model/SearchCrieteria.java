package com.mycart.user.model;

import lombok.Data;

@Data
public abstract class SearchCrieteria {
	
	private boolean pagination = false;
    private int pageSize = 25;
   

}
