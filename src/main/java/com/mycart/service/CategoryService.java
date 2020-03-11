
package com.mycart.service;

import java.util.Set;

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
    	Set<Brand> brands = this.brandRepository.findAllByIdIn(dto.getBrandIds());
    	Category category = Category.from(dto);
    	if(dto.getParentId() == 0) {
    		category.setParent(null);
    	}else {
    		Category parentCategory = this.repository.findById(dto.getParentId()).orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.CATEGORY_NOT_FOUND));;
    		category.setParent(parentCategory);
    	}
    	
    	category.setBrands(brands);
        return CategoryResponse.from(this.repository.save(category));
    }

}
