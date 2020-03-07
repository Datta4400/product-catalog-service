
package com.mycart.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mycart.domain.Brand;
import com.mycart.dto.BrandDto;
import com.mycart.exception.ErrorCode;
import com.mycart.exception.ProductServiceException;
import com.mycart.repository.BrandRepository;
import com.mycart.response.BrandResponse;
import com.mycart.vo.BrandVO;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
@Service
public class BrandService {
	@Autowired
	BrandRepository repository;

	public BrandResponse getBrand(final Long brandId) throws Exception {

		return BrandResponse.from(this.repository.findOneById(brandId)
				.orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.PRODUCT_NOT_FOUND)));
	}
	
	public BrandResponse getBrand(final String name) throws Exception {

		return BrandResponse.from(this.repository.findOneByName(name)
				.orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.PRODUCT_NOT_FOUND)));
	}


	public Collection<BrandVO> getAllBrands() throws Exception {

		Collection<Brand> brands = this.repository.findAll();

		return brands.stream().map(BrandVO::from).collect(Collectors.toList());

	}

	public BrandResponse addBrand(BrandDto dto) {
		return BrandResponse.from(this.repository.save(Brand.from(dto)));
	}

	public void deleteBrand(@NonNull final Long brandId) {
		Brand brand = repository.findById(brandId).get();
		this.repository.deleteById(brandId);
	}

}
