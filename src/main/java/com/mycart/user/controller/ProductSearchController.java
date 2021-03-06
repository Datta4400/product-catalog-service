package com.mycart.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.response.GetAllProductResponse;
import com.mycart.user.service.ProductSearchService;

@RestController
@Validated
@RequestMapping(value = "/mycart/product")
public class ProductSearchController {

	@Autowired
	ProductSearchService service;

	@GetMapping("/search")
	@ResponseStatus(code = HttpStatus.OK)
	public GetAllProductResponse getProductBySearchCrieteria(@RequestParam final String crieteria) throws Exception {

		return this.service.getProductByCrieteria(crieteria);

	}

}
