
package com.mycart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mycart.domain.Brand;
import com.mycart.domain.Category;
import com.mycart.dto.CategoryDto;
import com.mycart.exception.ErrorCode;
import com.mycart.exception.ProductServiceException;
import com.mycart.repository.BrandRepository;
import com.mycart.repository.CategoryRepository;
import com.mycart.response.CategoryResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;
    
    @Autowired
    BrandRepository brandRepository ;

    public CategoryResponse getCategory(final Long categoryId) throws Exception {
        return CategoryResponse.from(this.repository.findOneById(categoryId)
        		
                                                    .orElseThrow(() -> new Exception()));
    }

    public CategoryResponse addCategory(CategoryDto dto) {
    	Brand brand = this.brandRepository.findById(dto.getBrandId()).orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.BRAND_NOT_FOUND));
    	Category category = Category.from(dto);
    	category.setBrand(brand);
        return CategoryResponse.from(this.repository.save(category));
    }

}
