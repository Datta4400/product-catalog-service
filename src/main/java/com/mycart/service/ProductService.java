
package com.mycart.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mycart.domain.Product;
import com.mycart.dto.ProductDto;
import com.mycart.exception.ErrorCode;
import com.mycart.exception.ProductServiceException;
import com.mycart.repository.BrandRepository;
import com.mycart.repository.CategoryRepository;
import com.mycart.repository.ProductRepository;
import com.mycart.response.ProductGroupByBrandResponse;
import com.mycart.response.ProductResponse;
import com.mycart.vo.ProductVO;

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
	private final BrandRepository brandRepository;

	public ProductVO getProduct(@NonNull Long id) throws Exception {
		Product product = repository.findById(id)
				.orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.PRODUCT_NOT_FOUND));
		return ProductVO.from(product);
	}
	
	public ProductGroupByBrandResponse getProductByBrand(@NonNull Long id) throws Exception {
		Collection<Product> products = repository.findAllByBrandId(id);
		Collection<ProductVO> productVOs = products.stream().map(ProductVO::from).collect(Collectors.toList());
		return ProductGroupByBrandResponse.from(productVOs);
	}

	public ProductResponse getAllProduct() throws Exception {
		Collection<Product> products = this.repository.findAll();
		Collection<ProductVO> productVOs = products.stream().map(ProductVO::from).collect(Collectors.toList());
		return ProductResponse.from(productVOs);

	}

	public ProductResponse addProducts(@NonNull Long brandId, @NonNull Long categoryId, Collection<ProductDto> productDtos) throws Exception {
		
		List<Product> products = productDtos.stream().map(Product::from).map( p -> {
			p.setBrand(brandRepository.findById(brandId).orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.BRAND_NOT_FOUND)));
			p.setCategory(categoryRepository.findById(categoryId).orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.CATEGORY_NOT_FOUND)));
			return p ;
		}).collect(Collectors.toList());
		
		this.repository.saveAll(products);
		Collection<ProductVO> productVOs = products.stream().map(ProductVO::from).collect(Collectors.toList());
		return ProductResponse.from(productVOs);

	}
	
	public void deleteProduct(@NonNull Long id) {
		this.repository.deleteById(id);
	}

}
