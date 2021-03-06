
package com.mycart.admin.controller;

import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.admin.dto.BrandDto;
import com.mycart.admin.service.BrandService;
import com.mycart.admin.vo.BrandVO;
import com.mycart.response.GetAllBrandResponse;
import com.mycart.response.GetBrandResponse;

@RestController
@Validated
@RequestMapping(value = "/mycart/brand")
public class BrandController {

	@Autowired
	private BrandService service;

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public GetBrandResponse getBrand(@Positive @PathVariable final Long id) throws Exception {
		return this.service.getBrand(id);
	}
	
	@GetMapping("all")
	@ResponseStatus(code = HttpStatus.OK)
	public GetAllBrandResponse getAllBrand() throws Exception {
		return this.service.getAllBrands();

	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public GetBrandResponse addBrand(@RequestBody @NotNull BrandDto dto) throws Exception {
		return this.service.addBrand(dto);
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteBrand(@Positive @PathVariable final Long id) throws Exception {
		this.service.deleteBrand(id);
	}


}
