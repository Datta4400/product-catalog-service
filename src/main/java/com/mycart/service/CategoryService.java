
package com.mycart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycart.domain.Category;
import com.mycart.dto.CategoryDto;
import com.mycart.repository.CategoryRepository;
import com.mycart.response.CategoryResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public CategoryResponse getCategory(final Long categoryId) throws Exception {

        return CategoryResponse.from(this.repository.findOneById(categoryId)
                                                    .orElseThrow(() -> new Exception()));
    }

    public CategoryResponse addCategory(CategoryDto dto) {
        return CategoryResponse.from(this.repository.save(Category.from(dto)));
    }

}
