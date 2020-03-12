
package com.mycart.admin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mycart.admin.dto.ProductDto;
import com.mycart.admin.entity.Product;
import com.mycart.admin.repository.BrandRepository;
import com.mycart.admin.repository.CategoryRepository;
import com.mycart.admin.repository.ProductRepository;
import com.mycart.admin.vo.ProductVO;
import com.mycart.exception.ErrorCode;
import com.mycart.exception.ProductServiceException;
import com.mycart.response.ProductResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
@Service
public class ProductService {

	@Autowired
	private final ProductRepository repository;

	@Autowired
	private final CategoryRepository categoryRepository;

	@Autowired
	private final BrandRepository brandRepository ;


	public ProductVO getProduct(@NonNull Long id) throws Exception {
		Product product = repository.findById(id)
				.orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.PRODUCT_NOT_FOUND));
		return ProductVO.from(product);
	}
	
	
	public ProductResponse getAllProduct() throws Exception {
		Collection<Product> products = this.repository.findAll();
		Collection<ProductVO> productVOs = products.stream().map(ProductVO::from).collect(Collectors.toList());
		return ProductResponse.from(productVOs);

	}

	public ProductResponse addProducts(Collection<ProductDto> productDtos) throws Exception {
		
		List<Product> products = new ArrayList<>();
		
		for(ProductDto dto : productDtos) {
			Product product = new Product();
			product.setName(dto.getName());
			product.setPrice(dto.getPrice());
			product.setColor(dto.getColor());
			product.setSku(dto.getSku());
			product.setBrand(brandRepository.findById(dto.getBrandId()).orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.BRAND_NOT_FOUND)));
			product.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.BRAND_NOT_FOUND)));
			products.add(product);
		}
		
		this.repository.saveAll(products);
		Collection<ProductVO> productVOs = products.stream().map(ProductVO::from).collect(Collectors.toList());
		return ProductResponse.from(productVOs);

	}
	
	public void deleteProduct(@NonNull Long id) {
		this.repository.deleteById(id);
	}

}
