
package com.mycart.admin.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mycart.admin.dto.BrandDto;
import com.mycart.admin.entity.Brand;
import com.mycart.admin.entity.Category;
import com.mycart.admin.repository.BrandRepository;
import com.mycart.admin.repository.CategoryRepository;
import com.mycart.admin.vo.BrandVO;
import com.mycart.exception.ErrorCode;
import com.mycart.exception.ProductServiceException;
import com.mycart.response.GetAllBrandResponse;
import com.mycart.response.GetBrandResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
@Service
public class BrandService {
    @Autowired
    BrandRepository repository;

    @Autowired
    CategoryRepository categoryRepositiry;

    public GetBrandResponse getBrand(final Long brandId) throws Exception {

	return GetBrandResponse.from(BrandVO.from(this.repository.findOneById(brandId)
		.orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.PRODUCT_NOT_FOUND))));
    }

  
    public GetAllBrandResponse getAllBrands() throws Exception {

	Set<Brand> brands = this.repository.findAll();
	return GetAllBrandResponse.from(BrandVO.from(brands));
    }

    public GetBrandResponse addBrand(BrandDto dto) {

	Brand brand = Brand.from(dto);
	Set<Category> categories = this.categoryRepositiry.findAllByIdIn(dto.getCategories());
	
	for (Category cat : categories) {
	    brand.getCategories().add(cat);
	}
	
	return GetBrandResponse.from(BrandVO.from(this.repository.save(brand)));
    }

    public void deleteBrand(@NonNull final Long brandId) {
	this.repository.findById(brandId).orElseThrow(()->new ProductServiceException(HttpStatus.BAD_REQUEST,ErrorCode.PRODUCT_NOT_FOUND))));

	this.repository.delete(brand);
    }

}
