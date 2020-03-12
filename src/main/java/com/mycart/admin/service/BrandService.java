
package com.mycart.admin.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

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
import com.mycart.response.BrandResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
@Service
public class BrandService {
	@Autowired
	BrandRepository repository;
	
	@Autowired
	CategoryRepository categoryRepositiry ;

	public BrandResponse getBrand(final Long brandId) throws Exception {

		return BrandResponse.from(BrandVO.from(this.repository.findOneById(brandId)
				.orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.PRODUCT_NOT_FOUND))));
	}
	
	public BrandResponse getBrand(final String name) throws Exception {

		return BrandResponse.from(BrandVO.from(this.repository.findOneByName(name)
				.orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.PRODUCT_NOT_FOUND))));
	}


	public Collection<BrandVO> getAllBrands() throws Exception {

		Collection<Brand> brands = this.repository.findAll();

		return brands.stream().map(BrandVO::from).collect(Collectors.toList());

	}

	public BrandResponse addBrand(BrandDto dto) {
		
		Brand brand = Brand.from(dto);
		Set<Category> categories = categoryRepositiry.findAllByIdIn(dto.getCategories());
		for(Category cat : categories) {
			brand.getCategories().add(cat);
		}
		//brand.setCategories(categories);
		return BrandResponse.from(BrandVO.from(this.repository.save(brand)));
	}

	public void deleteBrand(@NonNull final Long brandId) {
		Brand brand = repository.findById(brandId).get();
		this.repository.deleteById(brandId);
	}

}
