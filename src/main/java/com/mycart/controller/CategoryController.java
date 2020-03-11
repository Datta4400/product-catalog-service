
package com.mycart.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.dto.CategoryDto;
import com.mycart.response.CategoryResponse;
import com.mycart.service.CategoryService;

@RestController
@Validated
@RequestMapping(value = "/mycart/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryResponse getCategory(@PathVariable final Long id) throws Exception {
        return this.service.getCategory(id);

    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody @NotNull CategoryDto dto) throws Exception {
        return this.service.addCategory(dto);

    }

}
