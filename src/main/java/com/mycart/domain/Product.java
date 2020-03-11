
package com.mycart.domain;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycart.dto.ProductDto;
import com.mycart.vo.ProductVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String color;

	private float size;

	private String sku;

	private double price;

	@JsonIgnore
	@ManyToOne(targetEntity = Brand.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "brandId")
	private Brand brand;

	@JsonIgnore
	@ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;

	public static final Product from(ProductDto dto) {
		return Product.builder().name(dto.getName()).price(dto.getPrice()).color(dto.getColor()).sku(dto.getSku())
				.size(dto.getSize()).build();
	}

	public static final List<Product> from(List<ProductDto> dtos) {
		return dtos.stream().map(Product::from).collect(Collectors.toList());
	}
	
	public static final ProductVO from(Product product) {
		return ProductVO.builder().name(product.getName()).price(product.getPrice()).color(product.getColor()).sku(product.getSku())
				.size(product.getSize()).build();
	}

}
