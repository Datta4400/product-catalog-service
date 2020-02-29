package com.mycart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.domain.Product;
import com.mycart.service.ProductSearchService;

@RestController
@Validated
@RequestMapping(value = "/mycart/search")
public class ProductSearchController {

	@Autowired
	ProductSearchService service;

	@GetMapping("/product")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Product> getProductBySearchCrieteria(@RequestParam final String crieteria) throws Exception {

		return this.service.getProductByCrieteria(crieteria);

	}

}
