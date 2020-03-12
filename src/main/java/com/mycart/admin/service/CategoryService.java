
package com.mycart.admin.service;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mycart.admin.dto.CategoryDto;
import com.mycart.admin.entity.Brand;
import com.mycart.admin.entity.Category;
import com.mycart.admin.repository.BrandRepository;
import com.mycart.admin.repository.CategoryRepository;
import com.mycart.admin.vo.CategoryVO;
import com.mycart.exception.ErrorCode;
import com.mycart.exception.ProductServiceException;
import com.mycart.response.CategoryResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    @Autowired
   private BrandRepository brandRepository ;

    public CategoryResponse getCategory(final Long categoryId) throws Exception {
        return CategoryResponse.from(CategoryVO.from(this.repository.findOneById(categoryId)
        		
                                                    .orElseThrow(() -> new Exception())));
    }
    
    public Collection<Category> getAllSubCategory(final Long parentId) throws Exception {
    
    //	Collection<Category> categories = this.repository.findById(parentId);
    	
    	Category parentCategory = this.repository.findById(parentId).orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.CATEGORY_NOT_FOUND));
    	final Collection<Category> subCategories= parentCategory.getChildren();
    	
    //	for(Category cat : categories) {
    //		buildTree(cat) ;
   
    	return subCategories ;
    
    }
    
    public void buildTree(Category cat) {
        System.out.println(cat.getName());
        if (cat.getChildren().size() > 0) {
            for (Category c : cat.getChildren()) {
            	buildTree(c);
            }
        }
    }

    public CategoryResponse addCategory(CategoryDto dto) {
    	Set<Brand> brands = this.brandRepository.findAllByIdIn(dto.getBrandIds());
    	Category category = Category.from(dto);
    	if(dto.getParentId() == 0) {
    		category.setParent(null);
    	}else {
    		Category parentCategory = this.repository.findById(dto.getParentId()).orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.CATEGORY_NOT_FOUND));
    		category.setParent(parentCategory);
    	}
    	
    	category.setBrands(brands);
        return CategoryResponse.from(CategoryVO.from(this.repository.save(category)));
    }

}
