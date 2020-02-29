
package com.mycart.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mycart.dto.ProductDto;

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
	private Long productId;

	private String name;

	private String color;

	private float size;

	private String sku;

	private double price;
	
	private String brandName ;
	
	@ManyToOne    
	@JoinColumn(name="brandId")
    private Brand brand;


	public static final Product from(ProductDto dto) {
		return Product.builder().name(dto.getName()).price(dto.getPrice()).color(dto.getColor()).sku(dto.getSku())				
				.size(dto.getSize())
				.brandName(dto.getBrandName())
				.build();
	}

}
