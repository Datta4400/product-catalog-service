
package com.mycart.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mycart.domain.Brand;
import com.mycart.domain.Category;
import com.mycart.domain.Product;
import com.mycart.dto.ProductDto;
import com.mycart.exception.ErrorCode;
import com.mycart.exception.ProductServiceException;
import com.mycart.repository.BrandRepository;
import com.mycart.repository.CategoryRepository;
import com.mycart.repository.ProductRepository;
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

	public ProductVO getProduct(@NonNull Long productId) throws Exception {
		Product product = repository.findById(productId).orElseThrow(() -> new ProductServiceException(HttpStatus.BAD_REQUEST, ErrorCode.PRODUCT_NOT_FOUND));
		return ProductVO.from(product);

	}

	public ProductResponse getAllProducts() throws Exception {
		Collection<Product> products = this.repository.findAll() ;
		return ProductResponse.from(products);

	}

	public ProductVO addProduct(ProductDto productDto) throws Exception {

		Category category = categoryRepository.findOneByName(productDto.getCategoryName())
				.orElseThrow(() -> new Exception());
		Brand brand = brandRepository.findOneByName(productDto.getBrandName()).orElseThrow(() -> new Exception());
		productDto.setBrandId(brand.getBrandId());
		productDto.setCategoryId(category.getCategoryId());

		Product product = Product.from(productDto);

		product = repository.save(product);

		return getProduct(product.getProductId());

	}

	public ProductResponse addProducts(Collection<ProductDto> productDtos) throws Exception {


		List<Product> products = productDtos.stream().map(productDto -> {
			//Category category = categoryRepository.findOneByName(productDto.getCategoryName()).get();
					
			Brand brand = brandRepository.findOneByName(productDto.getBrandName()).get();
			productDto.setBrandId(brand.getBrandId());
		//	productDto.setCategoryId(category.getCategoryId());
			return productDto;
		}).map(Product::from).collect(Collectors.toList());

		products = (List<Product>) this.repository.saveAll(products);

		return ProductResponse.from(products);

	}

}
